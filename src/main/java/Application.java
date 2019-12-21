import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.mainFunction.FunctionNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printFunctions();
        FunctionNumber functionNumber = new FunctionNumber(InputView.inputFunctionNumber());

        if (functionNumber.isRegisterOrder()) {
            registerOrder();
        }

        if (functionNumber.isPayOrder()) {
            payOrder();
        }

        if (functionNumber.isExit()) {
            exit();
        }

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private static void registerOrder() {
    }

    private static void payOrder() {
    }

    private static void exit() {
    }
}
