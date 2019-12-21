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

    public void on() {
        int selectNumber = InputView.inputMainMenu();

        if (selectNumber < MENU || selectNumber > OFF) {
            on();
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
        Table table = getTable();

        if (selectMenu(select)) {
            doOrder(table);
            return;
        }
        doPayment(table);
    }

    private void doOrder(Table table) {
        Order order = getOrder();
        table.addOrder(order);
    }

    private void doPayment(Table table) {
        if (table.hasNotOrders()) {
            OutputView.printNoOrders();
            doSelection(PAYMENT);
        }
        PaymentPolicyDTO paymentPolicyDTO = getPaymentPolicyDTO(table);
        Payment payment = table.toPayment(paymentPolicyDTO);

        OutputView.printFinalPrice(DiscountGroup.getDiscountPrice(payment));
        table.clear();
    }

    private PaymentPolicyDTO getPaymentPolicyDTO(Table table) {
        OutputView.printOrders(table.getOrders());
        OutputView.printPaymentPolicy(table.getNumber());
        try {
            return new PaymentPolicyDTO(InputView.inputPaymentPolicy());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorLog(e.getMessage());
            return getPaymentPolicyDTO(table);
        }
    }

    private Table getTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        try {
            return TableRepository.findById(tableNumber);
        } catch (NoSuchElementException e) {
            OutputView.printErrorLog(e.getMessage());
            return getTable();
        }
    }

    private Order getOrder() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        try {
            Menu menu = MenuRepository.findById(menuNumber);
            int menuSize = InputView.inputMenuAmount();

            return menu.toOrder(menuSize);
        } catch (NoSuchElementException e) {
            OutputView.printErrorLog(e.getMessage());
            return getOrder();
        }
    }

    private boolean selectMenu(int select) {
        return select == MENU;
    }

}
