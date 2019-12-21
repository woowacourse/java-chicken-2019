import java.util.List;

import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while (true) {
            OutputView.printMainView();
            Function function = createFunctionByInput();
            if (function.isTermination()) {
                break;
            }
            OutputView.printTables(tables);
            Table table = findTableByInput();
            if (function.isRegisterOrder()) {
                registerOrder(table);
            }
            if (function.isPayment()) {
                payTableAmount(table);
            }
        }
    }
    private static void registerOrder(Table table) {
        OutputView.printMenus(menus);
        Menu menu = findMenuByInput();
        registerOrderByQuantity(menu, table);
    }

    private static void registerOrderByQuantity(Menu menu, Table table) {
        int quantity = InputView.inputMenuQuantity();
        try {
            table.addOrder(menu, quantity);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
        }
    }

    private static void payTableAmount(Table table) {
        try {
            validateOrderedTable(table);
            OutputView.printBills(table.getBills());
            OutputView.printStartPayment(table);

            Payment payment = createPaymentByInput();
            int tableAmount = table.calculateAmount();
            OutputView.printFinalPaymentAmount(payment.calculateBySelect(tableAmount));
            table.completePayment();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
        }
    }

    private static void validateOrderedTable(Table table) {
        if (table.isNoOrder()) {
            throw new IllegalArgumentException("주문이 등록되어 있지 않은 테이블입니다.");
        }
    }

    private static Function createFunctionByInput() {
        try {
            return new Function(InputView.inputFunction());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return createFunctionByInput();
        }
    }

    private static Table findTableByInput() {
        try {
            return TableRepository.findByTableNumber(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return findTableByInput();
        }
    }

    private static Menu findMenuByInput() {
        try {
            return MenuRepository.findByMenuNumber(InputView.inputRegisterMenu());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return findMenuByInput();
        }
    }

    private static Payment createPaymentByInput() {
        try {
            return new Payment(InputView.inputPaymentMethod());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return createPaymentByInput();
        }
    }
}
