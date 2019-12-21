package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("메뉴가 치킨인지 아닌지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"CHICKEN,true", "BEVERAGE,false"})
    void isChicken(Category category, boolean result) {
        Menu menu = new Menu(1, "메뉴", category, 1000);
        assertThat(menu.isChicken()).isEqualTo(result);
    }

    @DisplayName("입력한 갯수에따라 복수의 메뉴로 변환")
    @Test
    void list() {
        Menu menu = new Menu(1, "메뉴", Category.CHICKEN, 1000);
        List<Menu> orders = menu.list(10);

        assertThat(orders.size()).isEqualTo(10);
    }
}