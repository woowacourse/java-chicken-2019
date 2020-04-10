package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PosFunctionTest {

    @Test
    void of() {
        assertThat(PosFunction.of(1)).isEqualTo(PosFunction.ORDER_REGISTRATION);
        assertThat(PosFunction.of(2)).isEqualTo(PosFunction.PAYMENT);
        assertThat(PosFunction.of(3)).isEqualTo(PosFunction.EXIT);
    }

    @Test
    void getCode() {
        assertThat(PosFunction.ORDER_REGISTRATION.getCode()).isEqualTo(1);
        assertThat(PosFunction.PAYMENT.getCode()).isEqualTo(2);
        assertThat(PosFunction.EXIT.getCode()).isEqualTo(3);
    }

    @Test
    void getPosFunctionsByCodeKoreanMap() {
        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "주문등록");
        expected.put(2, "결제하기");
        expected.put(3, "프로그램 종료");

        assertThat(PosFunction.getPosFunctionsByCodeKoreanMap())
            .isEqualTo(expected);
    }

    @Test
    void testToString() {
        assertThat(PosFunction.ORDER_REGISTRATION.toString()).isEqualTo("주문등록");
        assertThat(PosFunction.PAYMENT.toString()).isEqualTo("결제하기");
        assertThat(PosFunction.EXIT.toString()).isEqualTo("프로그램 종료");
    }
}