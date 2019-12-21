package exception;

public class EmptyOrderException extends Exception {
    public EmptyOrderException() {
        System.out.println("주문내역이 존재하지 않습니다.\n");
    }
}
