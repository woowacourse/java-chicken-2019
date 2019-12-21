import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printFunctions();
        final int functionNumber = InputView.inputFunctionNumber();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public static void placeOrder() {

    }

    public static void checkout() {
    }

    public static boolean quit(int quitProgram) {
        return quitProgram == 3;
    }
}
