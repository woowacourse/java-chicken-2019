package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @DisplayName("테이블 번호로 테이블 가져오기")
    @Test
    void findById() {
        int tableNumber = 1;
        Table table = TableRepository.findById(tableNumber);

        assertThat(table.equalId(tableNumber)).isTrue();
    }


    @DisplayName("잘못된 테이블번호 선택시 예외 발생")
    @Test
    void findByIdFail() {
        int tableNumber = 0;
        assertThatThrownBy(() -> TableRepository.findById(tableNumber))
                .isInstanceOf(NoSuchElementException.class);
    }
}