import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int functionNumber = InputView.inputFunctionNumber();;
        if (functionNumber != 3) {
            spiltFunction(functionNumber);
        }
        System.out.println("프로그램 종료");
    }

    private static void spiltFunction(int functionNumber) {
        final List<Table> tables = TableRepository.tables();
        for (Table table: tables) {
            System.out.println(table.toString());
        }

        OutputView.printTables(tables);
        if (functionNumber == 1) {
            doIfNumberIsOne();
        }
        if (functionNumber == 2) {
            final int tableBillNumber = InputView.inputTableBillNumber();
        }

    }

    private static void doIfNumberIsOne() {
        final int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int MenuCount =  InputView.inputMenuCount();
        setMenu(tableNumber, menuNumber, MenuCount);
    }

    private static void setMenu(int tableNumber, int menuNumber, int MenuCount) {

    }
}
