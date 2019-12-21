package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersTest {

    @DisplayName("주문 항목이 가지고 있는 치킨 메뉴의 갯수")
    @Test
    void chickenSize() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 100);

        Orders orders = Orders.emptyOrders();
        orders.add(chicken.toOrder(1));
        orders.add(beverage.toOrder(1));

        assertThat(orders.chickenSize()).isEqualTo(1);
    }

    @DisplayName("주문 항목의 가격 총합")
    @Test
    void getPrice() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 200);

        Orders orders = Orders.emptyOrders();
        orders.add(chicken.toOrder(1));
        orders.add(beverage.toOrder(1));

        assertThat(orders.getPrice()).isEqualTo(300);
    }

    @DisplayName("주문 수량이 99개가 넘어갈 경우 예외발생")
    @Test
    void validateMaximumSize() {
        Orders order = Orders.emptyOrders();
        order.add(aMenu(Category.CHICKEN, 1).toOrder(99));


        assertThatThrownBy(() -> order.add(aMenu(Category.CHICKEN, 1).toOrder(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    public Menu aMenu(Category category, int price) {
        return new Menu(1, "메뉴", category, price);
    }
}