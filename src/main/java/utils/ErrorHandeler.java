package utils;

import java.io.InvalidObjectException;

public class ErrorHandeler {
    public static OrderController makeOrderController() {
        try {
            return new OrderController();
        } catch (InvalidObjectException e) {
            System.out.println("\n## 주문 중 오류가 발생했습니다. 사유: " + e.getMessage());
            return makeOrderController();
        }
    }

    public static PaymentController makePaymentController() {
        try {
            return new PaymentController();
        } catch (InvalidObjectException e) {
            System.out.println("\n## 주문 중 오류가 발생했습니다. 사유: " + e.getMessage());
            return makePaymentController();
        } catch (NullPointerException e) {
        System.out.println("\n## 주문 중 오류가 발생했습니다. 사유: 아무것도 주문하지 않은 테이블");
        return makePaymentController();
        }
    }
}
