package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrdersTest {

    @DisplayName("주문 항목이 가지고 있는 치킨 메뉴의 갯수")
    @Test
    void chickenSize() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 100);

        Orders orders = Orders.emptyOrders();
        orders.addMenu(Arrays.asList(chicken, beverage));

        assertThat(orders.chickenSize()).isEqualTo(1);
    }

    @DisplayName("주문 항목의 가격 총합")
    @Test
    void getPrice() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 200);

        Orders orders = Orders.emptyOrders();
        orders.addMenu(Arrays.asList(chicken, beverage));

        assertThat(orders.getPrice()).isEqualTo(300);
    }

    @DisplayName("주문 수량이 99개가 넘어갈 경우 예외발생")
    @Test
    void validateMaximumSize() {
        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            menus.add(aMenu(Category.CHICKEN, 1));
        }

        Orders order = Orders.emptyOrders();

        assertThatThrownBy(() -> order.addMenu(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }


    public Menu aMenu(Category category, int price) {
        return new Menu(1, "메뉴", category, price);
    }
}