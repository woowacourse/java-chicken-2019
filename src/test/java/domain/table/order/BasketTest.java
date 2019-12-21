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
}