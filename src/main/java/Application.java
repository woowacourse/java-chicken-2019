import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static List<Table> tables = TableRepository.tables();
    private static List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        int functionNumber = InputView.inputFunctionNumber();
        while (functionNumber != 3) {
            spiltFunction(functionNumber);
            functionNumber = InputView.inputFunctionNumber();
        }
        System.out.println("프로그램 종료");
    }

    private static void spiltFunction(int functionNumber) {
        OutputView.printTables(tables);
        if (functionNumber == 1) {
            doIfNumberIsOne();
        }
        if (functionNumber == 2) {
            doIfNumberIsTwo();
        }

    }

    private static void doIfNumberIsOne() {
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        for (Table table: tables) {
            if (table.toString().equals(Integer.toString(tableNumber))) {
                setMenu(table);
            }
        }
    }

    private static void setMenu(Table table) {
        final int menuNumber = InputView.inputMenuNumber();
        final int MenuCount =  InputView.inputMenuCount();
        for (Menu menu: menus) {
            if (menu.isNumber(menuNumber)) {
                table.setMenu(menu.getName(), MenuCount, menu.getPrice());
            }
        }
    }

    private static void doIfNumberIsTwo() {
        final int tableBillNumber = InputView.inputTableBillNumber();
        for (Table table: tables) {
            if (table.toString().equals(Integer.toString(tableBillNumber))) {
                setBill(table);
            }
        }
    }

    private static void setBill(Table table) {
        
    }
}
