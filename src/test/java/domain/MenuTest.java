package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("메뉴가 치킨인지 아닌지 확인하기")
    @ParameterizedTest
    @CsvSource(value = {"CHICKEN,true", "BEVERAGE,false"})
    void isChicken(Category category, boolean result) {
        Menu menu = new Menu(1, "메뉴", category, 1000);
        assertThat(menu.isChicken()).isEqualTo(result);
    }

}