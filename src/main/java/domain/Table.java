package domain;

import domain.reserved.OrderedMenus;

/*
* •다음 Table 클래스를 활용해 구현해야 한다.
•Table에 기본 생성자를 추가할 수 없다.
•필드(인스턴스 변수)의 접근 제어자는 private으로 구현해야 한다.
*/
public class Table {
    private final OrderedMenus orderedMenus = new OrderedMenus();
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isMatch(int number) {
        return this.number == number;
    }

    public OrderedMenus getOrderedMenus() {
        return orderedMenus;
    }

    public void addMenu(Menu menu, int capacity) {
        orderedMenus.addMenu(menu, capacity);
    }

    public int getNumber() {
        return number;
    }

    public boolean isExistMenuBy(int menuId) {
        return orderedMenus.isExistBy(menuId);
    }

    public boolean isExistMenu() {
        return orderedMenus.isExistMenu();
    }
}
