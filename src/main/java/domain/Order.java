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
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        return tableNumber;
    }

    public int selectMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();

        return menuNumber;
    }

    public int selectMenuQuantity() {
        int quantity = InputView.inputMenuQuantity();

        return quantity;
    }

    @Override
    public String toString() {
        return tableNumber + " " + menu[0] + " " + menu[1];
    }

}
