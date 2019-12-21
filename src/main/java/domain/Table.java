package domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Table에 기본생성자를 추가할 수 없다.
 * 필드(인스턴스변수)의 접근제어자는 private으로 구현해야한다.
 */
public class Table {
    private final int number;
    private Map<Menu, Integer> order;

    public Table(final int number) {
        this.number = number;
        initOrder();
    }

    private void initOrder() {
        order = new HashMap<>();
    }

    public void getOrder(Menu menu, int menuHowMany) {
        order.put(menu, menuHowMany);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
