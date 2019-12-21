import domain.Exception.MenuDoesNotExistExeption;
import domain.Exception.TableDoesNotExistExeption;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import domain.Function.FunctionNumber;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        FunctionNumber functionNumber = askFunctionNumber();

        if (functionNumber.isRegisterOrder()) {
            registerOrder();
        }

        if (functionNumber.isPayOrder()) {
            payOrder();
        }

        if (functionNumber.isExit()) {
            exit();
        }
    }

    private static FunctionNumber askFunctionNumber() {
        try {
            OutputView.printFunctions();
            return new FunctionNumber(InputView.inputFunctionNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return askFunctionNumber();
        }
    }

    private static void registerOrder() {
        Table table = askTable();
        Menu menu = askMenu();
        final int menuAmount = InputView.inputMenuAmount();

        table.addOrder(menu, menuAmount);
    }

    private static Table askTable() {
        try {
            return showTablesAndSelectOne();
        } catch (TableDoesNotExistExeption e) {
            OutputView.printMessage(e.getMessage());
            return askTable();
        }
    }

    private static Table showTablesAndSelectOne() {
        OutputView.printTables(TableRepository.tables());

        final int tableNumber = InputView.inputTableNumber();
        return TableRepository.findTableBy(tableNumber);
    }

    private static Menu askMenu() {
        try {
            return showMenusAndSelectOne();
        } catch (MenuDoesNotExistExeption e) {
            OutputView.printMessage(e.getMessage());
            return askMenu();
        }
    }

    private static Menu showMenusAndSelectOne() {
        OutputView.printMenus(MenuRepository.menus());

        final int menuNumber = InputView.inputMenuToRegister();
        return MenuRepository.findMenuBy(menuNumber);
    }

    private static void payOrder() {
    }

    private static void exit() {
    }
}
