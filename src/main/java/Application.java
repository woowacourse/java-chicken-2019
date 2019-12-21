import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static List<Table> tables = TableRepository.tables();

    public static void main(String[] args) {
        int functionNumber = InputView.inputFunctionNumber();;
        if (functionNumber != 3) {
            spiltFunction(functionNumber);
        }
        System.out.println("프로그램 종료");
    }

    private static void spiltFunction(int functionNumber) {
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
        for (Table table: tables) {
            if (table.toString().equals(Integer.toString(tableNumber))) {
                setMenu(menus, table);
            }
        }
    }

    private static void setMenu(List<Menu> menus, Table table) {
        final int menuNumber = InputView.inputMenuNumber();
        final int MenuCount =  InputView.inputMenuCount();
        for (Menu menu: menus) {
            if (menu.isNumber(menuNumber)) {
                table.setMenu(menu.getName(), MenuCount, menu.getPrice());
            }
        }
    }
}
