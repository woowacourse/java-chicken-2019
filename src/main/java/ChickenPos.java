import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import domain.Payment;
import domain.Table;
import domain.TableRepository;
import domain.discount.DiscountGroup;
import view.InputView;
import view.OutputView;
import view.dto.PaymentPolicyDTO;

import java.util.NoSuchElementException;

public class ChickenPos {
    private static final int MENU = 1;
    private static final int PAYMENT = 2;
    private static final int OFF = 3;

    private ChickenPos() {
    }

    public static ChickenPos init() {
        return new ChickenPos();
    }

    public void mainMenu() {
        int selectNumber = InputView.inputMainMenu();

        if (selectNumber < MENU || selectNumber > OFF) {
            mainMenu();
            return;
        }

        while (untilOff(selectNumber)) {
            doSelection(selectNumber);
            selectNumber = InputView.inputMainMenu();
        }
    }

    private boolean untilOff(int select) {
        return select != OFF;
    }

    private void doSelection(int select) {
        Table table;
        try {
            table = getTable();
        } catch (NoSuchElementException e) {
            OutputView.printErrorLog(e.getMessage());
            mainMenu();
            return;
        }

        if (selectMenu(select)) {
            doOrder(table);
            return;
        }
        doPayment(table);
    }

    private void doOrder(Table table) {
        Order order;
        try {
            order = getOrder();
            table.addOrder(order);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            OutputView.printErrorLog(e.getMessage());
            doOrder(table);
        }
    }

    private void doPayment(Table table) {
        if (table.hasNotOrders()) {
            OutputView.printNoOrders();
            mainMenu();
            return;
        }

        PaymentPolicyDTO paymentPolicyDTO = inputPaymentPolicy(table);
        if (paymentPolicyDTO != null) {
            Payment payment = table.toPayment(paymentPolicyDTO);
            OutputView.printFinalPrice(DiscountGroup.getDiscountPrice(payment));
            table.clear();
        }
    }

    private PaymentPolicyDTO inputPaymentPolicy(Table table) {
        PaymentPolicyDTO paymentPolicyDTO;
        try {
            paymentPolicyDTO = getPaymentPolicyDTO(table);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorLog(e.getMessage());
            mainMenu();
            return null;
        }
        return paymentPolicyDTO;
    }

    private PaymentPolicyDTO getPaymentPolicyDTO(Table table) {
        OutputView.printOrders(table.getOrders());
        OutputView.printPaymentPolicy(table.getNumber());
        return new PaymentPolicyDTO(InputView.inputPaymentPolicy());
    }

    private Table getTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        return TableRepository.findById(tableNumber);
    }

    private Order getOrder() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        Menu menu = MenuRepository.findById(menuNumber);
        int menuSize = InputView.inputMenuAmount();

        return menu.toOrder(menuSize);
    }

    private boolean selectMenu(int select) {
        return select == MENU;
    }

}
