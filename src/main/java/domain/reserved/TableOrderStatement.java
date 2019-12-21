package domain.reserved;

import domain.Menu;
import domain.Table;

// 테이블 넘버와 Table의 주문 목록을 가진다.
public class TableOrderStatement extends Table {
    OrderedMenus orderedMenus = new OrderedMenus();

    public TableOrderStatement(int number) {
        super(number);
    }

    public OrderedMenus getOrderedMenus() {
        return orderedMenus;
    }

    public void addMenu(Menu menu) {
        orderedMenus.addMenu(menu);
    }


}
