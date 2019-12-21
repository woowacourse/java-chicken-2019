package domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuRepositoryTest {

    @Test
    @DisplayName("메뉴 넘버로 해당하는 Menu리턴하기")
    void findByMenuNumber() {
        Menu byMenuNumber = MenuRepository.findByMenuNumber(1);

        assertThat(byMenuNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("메뉴 넘버에 없는 Menu일 경우 에러 터뜨리기")
    void findByMenuNumberWithError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Menu byMenuNumber = MenuRepository.findByMenuNumber(100);
                });
    }
}