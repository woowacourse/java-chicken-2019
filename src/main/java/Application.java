import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    private static final int MAIN_ORDER = 1;
    private static final int MAIN_PAYMENT = 2;
    private static final int MAIN_EXIT = 3;

    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());
        Menus menus = new Menus(MenuRepository.menus());
        do {
            int inputMainMenu = InputView.inputMainMenu();
            if (inputMainMenu == MAIN_ORDER) {
                orderMain(tables, menus);
            }
            if (inputMainMenu == MAIN_PAYMENT) {
                paymentMain(tables);
            }
            if (inputMainMenu == MAIN_EXIT) {
                break;
            }
        } while (true);
    }

    private static void orderMain(Tables tables, Menus menus) {
        OutputView.showSelectTableAsOrder();

        Table inputTable = tables.findTable(InputView.inputTableNumber(tables));
        Menu inputMenu = menus.findMenu(InputView.inputMenuNumber(menus));
        int menuAmount = InputView.inputMenuAmount(inputTable, inputMenu);

        inputTable.addMenu(inputMenu, menuAmount);
    }

    private static void paymentMain(Tables tables) {
        OutputView.showSelectTableAsPayment();
        Table inputTable = tables.findTable(InputView.inputTableNumber(tables));

        if (!inputTable.isOrdered()) {
            OutputView.showNothingOrdered();
            return;
        }

        OutputView.printTableOrderedList(inputTable.allMenu());
        OutputView.printFinalPrice(Calculator.cashAndCard(inputTable));
        inputTable.removeAllOrdered();
    }
}
