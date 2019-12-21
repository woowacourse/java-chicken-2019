package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    private static Stream<Arguments> sourceHasNotOrders() {
        return Stream.of(
                Arguments.of(new Menu(1, "1", Category.CHICKEN, 100).toOrder(1), false)
        );
    }

    @DisplayName("주문 내역이 없는지 확인")
    @ParameterizedTest
    @MethodSource("sourceHasNotOrders")
    void hasNotOrders(Order order, boolean result) {
        Table table = new Table(1);

        assertThat(table.hasNotOrders()).isTrue();

        table.addOrder(order);

        assertThat(table.hasNotOrders()).isEqualTo(result);
    }

    @DisplayName("주문 내역 지우기")
    @Test
    void clear() {
        Table table = new Table(1);

        table.addOrder((new Menu(1, "1", Category.CHICKEN, 100).toOrder(1)));

        assertThat(table.hasNotOrders()).isFalse();
        table.clear();
        assertThat(table.hasNotOrders()).isTrue();

    }
}