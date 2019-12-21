import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import domain.Function.FunctionNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

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
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.findTableBy(tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuToRegister();
        final int menuAmount = InputView.inputMenuAmount();

        table.addOrder(menuNumber, menuAmount);
    }

    private static void payOrder() {
    }

    private static void exit() {
    }
}
