package domain.table;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TableRepositoryTest {

    @Test
    @DisplayName("테이블 넘버로 해당하는 Table리턴하기")
    void findByTableNumber() {
        Table byTableNumber = TableRepository.findByTableNumber(1);

        assertThat(byTableNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("테이블 넘버에 없는 Table일 경우 에러 터뜨리기")
    void findByTableNumberWithError() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Table byTableNumber = TableRepository.findByTableNumber(7);
                });
    }
}