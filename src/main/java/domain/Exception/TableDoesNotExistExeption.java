package domain.Exception;

public class TableDoesNotExistExeption extends RuntimeException {
    private static final String TABLE_DOES_NOT_EXIST_MESSAGE = "존재하지 않는 테이블입니다.";

    public TableDoesNotExistExeption() {
        super(TABLE_DOES_NOT_EXIST_MESSAGE);
    }
}
