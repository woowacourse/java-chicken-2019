package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    private static Stream<Arguments> sourceHasNotOrders() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Menu(1, "1", Category.CHICKEN, 100)), false),
                Arguments.of(new ArrayList<>(), true)
        );
    }

    @DisplayName("주문 내역이 없는 지확인")
    @ParameterizedTest
    @MethodSource("sourceHasNotOrders")
    void hasNotOrders(List<Menu> orders, boolean result) {
        Table table = new Table(1);

        table.addOrders(orders);

        assertThat(table.hasNotOrders()).isEqualTo(result);
    }

    @DisplayName("주문 내역 지우기")
    @Test
    void clear() {
        Table table = new Table(1);

        table.addOrders(Arrays.asList(new Menu(1, "1", Category.CHICKEN, 100)));

        assertThat(table.hasNotOrders()).isFalse();
        table.clear();
        assertThat(table.hasNotOrders()).isTrue();

    }
}