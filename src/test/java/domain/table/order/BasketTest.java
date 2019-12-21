package domain.table.order;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasketTest {

    @Test
    @DisplayName("basket 생성 테스트")
    void name() {
        Menu byMenuNumber = MenuRepository.findByMenuNumber(1);
        Basket basket = new Basket(byMenuNumber, 2);
        assertThat(basket.getCountMenuNumber()).isEqualTo(2);
    }

    @Test
    @DisplayName("개수에 따른 할인 테스트")
    void getCharge() {
        Menu byMenuNumber = MenuRepository.findByMenuNumber(1);
        Integer price = byMenuNumber.getPrice();
        Basket basket1 = new Basket(byMenuNumber, 20);
        assertThat(basket1.getCharge()).isEqualTo(price * 20 - 20000);

        Basket basket2 = new Basket(byMenuNumber, 9);
        assertThat(basket2.getCharge()).isEqualTo(price * 9);
    }
}