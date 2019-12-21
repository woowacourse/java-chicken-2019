package domain;

import static org.junit.jupiter.api.Assertions.*;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test
    @TestDescription("인자로, 값을 넣었을 때 정상적으로 할인된 가격이 출력되는지 테스트합니다.")
    public void paymentTest(){
        int totalMoney = 10000;
        double creditCard = Payment.CREDIT_CARD.calculateWithPayment(totalMoney);
        double cash = Payment.CASH.calculateWithPayment(totalMoney);
        assertEquals(totalMoney,creditCard);
        assertEquals(totalMoney*0.95,cash);
    }
}