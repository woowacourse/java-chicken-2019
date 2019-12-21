package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {
    @Test
    void name() {
        assertThat(ErrorMessage.MENU_COUNT_OVERFLOW).isEqualTo("주문한 메뉴의 개수가 99개가 넘을 수 없습니다.");
    }
}