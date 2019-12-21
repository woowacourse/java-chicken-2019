package domain.discount;

import domain.Category;
import domain.Menu;
import domain.Order;
import domain.Orders;
import domain.Payment;
import domain.payment.PaymentPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AmountDiscountTest {

    @DisplayName("수량 할인 지원 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"9,false", "10,true"})
    void support(int amount, boolean result) {
        Order order = new Menu(1, "name", Category.CHICKEN, 1000).toOrder(amount);
        Orders orders = Orders.emptyOrders();
        orders.add(order);

        Payment payment = new Payment(orders, PaymentPolicy.CASH);

        assertThat(new AmountDiscount().support(payment)).isEqualTo(result);
    }

    @DisplayName("수량 할인 적용확인")
    @ParameterizedTest
    @CsvSource(value = {"9,90000", "10,90000", "20,180000"})
    void apply(int amount, double result) {
        Order order = new Menu(1, "name", Category.CHICKEN, 10000).toOrder(amount);
        Orders orders = Orders.emptyOrders();
        orders.add(order);

        Payment payment = new Payment(orders, PaymentPolicy.CASH);
        double originalPrice = payment.getPrice();

        assertThat(new AmountDiscount().apply(originalPrice, payment)).isEqualTo(result);
    }
}