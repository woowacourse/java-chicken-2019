import com.sun.tools.internal.ws.wsdl.document.Output;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.*;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {

        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while(true) {
            OutputView.printMain();
            final int mainDecision = InputView.inputMain();
            if (mainDecision == 1) {
                order(tables, menus);
                continue;
            }
            if (mainDecision == 2) {
                continue;
            }
            if (mainDecision == 3) {
                OutputView.printTerminatingProgram();
                return;
            }
            OutputView.printInvalidMainInput();
            continue;
        }
    }

    public static void order(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumberForOrder();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int menuQuantity = InputView.inputMenuQuantity();
        selectTableWithNumber(tables, tableNumber).orderMenu(orderMenuWithNumber(menus, menuNumber), menuQuantity);
    }

    public static Table selectTableWithNumber(List<Table> tables, int number) {
        Table returnTable = null;
        for (Table table: tables) {
            if (table.getNumber() == number) {
                returnTable = table;
            }
        }
        return returnTable;
    }


    public static Menu orderMenuWithNumber(List<Menu> menus, int number) {
        Menu returnMenu = null;
        for (Menu menu: menus) {
            if (menu.getNumber()==number) {
                returnMenu = menu;
            }
        }
        return returnMenu;
    }

}
