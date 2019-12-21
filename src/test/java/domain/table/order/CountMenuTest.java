package domain.table.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountMenuTest {

    @Test
    @DisplayName("메뉴의 개수를 생성 할 때 99개가 넘을 경우 Exception")
    void countError() {

        CountMenu countMenu1 = new CountMenu(99);
        assertThat(countMenu1.getCount()).isEqualTo(99);

        Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    CountMenu countMenu2 = new CountMenu(100);
                }
        );

    }
}