package domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private TableStatus tableStatus;
    private List<Menu> menus = new ArrayList<>();

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
        if (MenuConfig.MENU_LIMIT_NUM <= menus.size()) {
            throw new InvalidParameterException("더이상 메뉴를 추가할 수 없습니다.");
        }

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

    public boolean isTarget(int tableNumber) {
        return number == tableNumber;
    }
}
