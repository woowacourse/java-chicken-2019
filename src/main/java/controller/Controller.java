package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.PaymentMethod;
import domain.PosFunction;
import domain.Table;
import domain.TableRepository;
import java.util.List;
import java.util.stream.Collectors;
import view.IllegalUserInputException;
import view.InputView;
import view.OutputView;

public class Controller {

    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void run() {
        try {
            runWithoutExceptionCatch();
        } catch (Exception e) {
            OutputView.printExceptionMessage(e.getMessage());
        }
    }

    private static void runWithoutExceptionCatch() {
        PosFunction posFunction;

        do {
            OutputView.printPosFunctions(PosFunction.getPosFunctionsByCodeKoreanMap());
            posFunction = PosFunction.of(InputView.inputPosFunction());

            if (posFunction == PosFunction.ORDER_REGISTRATION) {
                register_order();
            }
            if (posFunction == PosFunction.PAYMENT) {
                pay();
            }
        } while (posFunction != PosFunction.EXIT);
    }

    private static void register_order() {
        OutputView.printTables(getTableNumbers(), getOrderedTableNumbers());
        final Table table = readTable();

        OutputView.printMenus(menus);
        final Menu menuToRegister = readMenu();

        table.registerMenu(menuToRegister, InputView.inputMenuCount());
    }

    private static List<Integer> getTableNumbers() {
        return tables.stream()
            .mapToInt(Table::getNumber)
            .boxed()
            .collect(Collectors.toList());
    }

    private static List<Integer> getOrderedTableNumbers() {
        return tables.stream()
            .filter(Table::hasOrdered)
            .mapToInt(Table::getNumber)
            .boxed()
            .collect(Collectors.toList());
    }

    private static Table readTable() {
        int tableNumber = InputView.inputTableNumber();

        return tables.stream()
            .filter(table -> table.isNumber(tableNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalUserInputException("존재하지 않는 테이블입니다."));
    }

    private static Menu readMenu() {
        int menuNumber = InputView.inputMenuNumber();

        return menus.stream()
            .filter(targetMenu -> targetMenu.isNumber(menuNumber))
            .findFirst()
            .orElseThrow(() -> new IllegalUserInputException("존재하지 않는 메뉴입니다."));
    }

    private static void pay() {
        OutputView.printTables(getTableNumbers(), getOrderedTableNumbers());
        final Table table = readTable();

        OutputView.printOrderHistory(table.getOrderHistory());

        final PaymentMethod paymentMethod = readPaymentMethodOf(table);

        OutputView.printFinalPaymentAmount(table.getPaymentAmount());
        table.pay(paymentMethod);
    }

    private static PaymentMethod readPaymentMethodOf(Table table) {
        OutputView.printMakingPaymentMessage(table.getNumber());
        return PaymentMethod.of(InputView.inputPaymentMethod());
    }
}
