package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PaymentMethodTest {

    @Test
    void of() {
        assertThat(PaymentMethod.of(1)).isEqualTo(PaymentMethod.CREDIT_CARD);
        assertThat(PaymentMethod.of(2)).isEqualTo(PaymentMethod.CASH);

        assertThatThrownBy(() -> PaymentMethod.of(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}