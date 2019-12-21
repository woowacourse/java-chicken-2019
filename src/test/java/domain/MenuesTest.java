package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MenuesTest {

    @DisplayName("주문 항목이 가지고 있는 치킨 메뉴의 갯수")
    @Test
    void chickenSize() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 100);
        Menues menues = new Menues(Arrays.asList(chicken, beverage));

        assertThat(menues.chickenSize()).isEqualTo(1);
    }

    @DisplayName("주문 항목의 가격 총합")
    @Test
    void getPrice() {
        Menu chicken = aMenu(Category.CHICKEN, 100);
        Menu beverage = aMenu(Category.BEVERAGE, 200);
        Menues menues = new Menues(Arrays.asList(chicken, beverage));

        assertThat(menues.getPrice()).isEqualTo(300);
    }

    public Menu aMenu(Category category, int price) {
        return new Menu(1, "메뉴", category, price);
    }
}