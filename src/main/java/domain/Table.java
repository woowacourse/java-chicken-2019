package domain;

import java.util.List;

public class Table {
    private final int number;
    private TableStatus tableStatus;
    private List<Menu> menus;

    public Table(final int number) {
        this.number = number;
        tableStatus = TableStatus.Wating;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    //todo: do other logic
    public void takeOrder(Menu menu) {
        //todo: refac
        tableStatus = TableStatus.Registered;
        addMenu(menu);
    }

    //todo: do other logic
    public void getSettled() {
        tableStatus =  TableStatus.Wating;
    }

    private void addMenu(Menu menu) {
        //todo: validation
        menus.add(menu);
    }
}
