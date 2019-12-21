package view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PaymentPolicyDTOTest {

    @DisplayName("정책번호 잘못 입력시 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"0,3"})
    void validate(int error1, int error2) {
        assertAll(
                () -> assertThatThrownBy(() -> new PaymentPolicyDTO(error1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new PaymentPolicyDTO(error2)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}