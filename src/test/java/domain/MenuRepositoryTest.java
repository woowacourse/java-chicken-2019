package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    @DisplayName("메뉴 찾기")
    @Test
    void findById() {
        Menu menu = MenuRepository.findById(1);

        assertThat(menu.equalId(1)).isTrue();
    }

    @DisplayName("없는 메뉴 찾을시 예외 발생")
    @Test
    void findByIdFail() {
        assertThatThrownBy(() -> MenuRepository.findById(0))
                .isInstanceOf(NoSuchElementException.class);
    }
}