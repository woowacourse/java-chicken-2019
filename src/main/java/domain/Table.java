package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Table에 기본생성자를 추가할 수 없다.
 * 필드(인스턴스변수)의 접근제어자는 private으로 구현해야한다.
 */
public class Table {
    final static int UNORDERED = 0;

    private HashMap<Menu, Integer> order;

    private final int number;


    public Table(final int number) {
        this.number = number;
        initOrder();
    }

    private void initOrder() {
        order = new HashMap<>();
    }

    public void registerOrder(Menu menu, int menuHowMany) {
        order.put(menu, menuHowMany);
    }

    public HashMap<Menu, Integer> getOrder() { return this.order; }

    public boolean isOrdered() {
        return order.size() != UNORDERED;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
