package domain.Exception;

public class TableDidNotOrderedExeption extends RuntimeException {
    private static final String MENU_DOES_NOT_EXIST_MESSAGE = "이 테이블은 주문 내역이 없습니다.";

    public TableDidNotOrderedExeption() {
        super(MENU_DOES_NOT_EXIST_MESSAGE);
    }
}
