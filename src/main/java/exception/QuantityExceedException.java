package exception;

public class QuantityExceedException extends Exception {
    public QuantityExceedException() {
        System.out.println("메뉴당 주문 가능 수량을 초과했습니다.\n");
    }
}
