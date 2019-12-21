package domain.discount;

import domain.Category;
import domain.Menu;
import domain.Order;
import domain.Orders;
import domain.Payment;
import domain.payment.PaymentPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CashDiscountTest {

    @DisplayName("현금 할인 적용여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"CASH,true", "CREDIT,false"})
    void support(PaymentPolicy paymentPolicy, boolean result) {
        Payment payment = new Payment(Orders.emptyOrders(), paymentPolicy);

        assertThat(new CashDiscount().support(payment)).isEqualTo(result);
    }

    @DisplayName("현금 할인 5% 적용")
    @Test
    void apply() {
        Order order = new Menu(1, "name", Category.CHICKEN, 10000).toOrder(10);
        Orders orders = Orders.emptyOrders();
        orders.add(order);

        Payment payment = new Payment(orders, PaymentPolicy.CASH);
        double originalPrice = payment.getPrice();

        assertThat(new CashDiscount().apply(originalPrice, payment)).isEqualTo(95000);
    }
}