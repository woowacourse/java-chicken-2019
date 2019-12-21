package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;


public class Order {
    private static final String name = "주문하기";
    private int tableNumber;
    private int[] menu;

    public Order() {
        menu = new int[2];

        this.tableNumber = selectTable();
        this.menu[0] = selectMenu();
        this.menu[1] = selectMenuQuantity();

        System.out.println(toString());
    }

    public int selectTable() {
        int tableNumber;
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        do {
            tableNumber = InputView.inputTableNumber();
        } while (!checkTable(tableNumber));

        return tableNumber;
    }

    public int selectMenu() {
        int menuNumber;
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        do {
            menuNumber = InputView.inputMenuNumber();
        } while (!checkMenu(menuNumber));

        return menuNumber;
    }

    public int selectMenuQuantity() {
        int quantity = InputView.inputMenuQuantity();

        return quantity;
    }


    /*없는 번호 체크하는 method*/
    public boolean checkTable(int tableNumber) {
        final List<Table> tables = TableRepository.tables();

        for (Table t : tables) {
            if (t.existTableNumber(tableNumber)) {
                return true;
            }
        }

        /*없는 테이블 입력 시*/
        OutputView.printNonexistTableNumbers();         //재입력 요구 메세지

        return false;
    }

    public boolean checkMenu(int menuNumber) {
        final List<Menu> menus = MenuRepository.menus();

        for (Menu m : menus) {
            if (m.existMenuNumber(menuNumber)) {
                return true;
            }
        }

        OutputView.printNonexistMenuNumbers();         //재입력 요구 메세지

        return false;
    }


    @Override
    public String toString() {
        return tableNumber + " " + menu[0] + " " + menu[1];
    }

}
