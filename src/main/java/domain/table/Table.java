package domain.table;

import domain.menu.Menu;
import domain.menu.Order;

public class Table {
    private final int number;
    private Order order;

    public Table(final int number) {
        order = new Order();
        this.number = number;
    }

    public boolean isRightTableNumber(int tableNumer) {
        return number == tableNumer;
    }

    /**
     * makeNewOrder는 메뉴와 그 개수를 받아 이를 테이블의 Order 객체에 추가하는 메서드이다.
     * 만약 새로운 메뉴라면 Order의 내부 리스트에 추가될 것이고,
     * 이전에 주문한 적이 있다면 Order의 내부 리스트에서 값이 갱신될 것이다.
     *
     * @param menu   주문할 메뉴의 정보를 전달하는 객체
     * @param number 주문할 메뉴의 개수를 전달하는 정수형 변수
     */
    public void makeNewOrder(Menu menu, int number) {
        order.addOrder(menu, number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    /**
     * 테스트용 코드. 주문된 양을 확인한다. 추후 삭제.
     * TDD할 시간이 없어 아쉬웠다.
     */
    public void printOrder() {
        order.printOrder();
    }
}
