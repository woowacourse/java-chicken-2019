package exception;

public class InvalidInputException extends IllegalArgumentException {

    public static final String NOT_NUMBER_EXCEPTION = "숫자가 아닌 값을 입력하실 수 없습니다.";
    public static final String WRONG_MAIN_MENU_NUMBER_EXCEPTION = "메인 메뉴 번호를 잘못 선택하셨습니다.";
    public static final String WRONG_MENU_NUMBER_EXCEPTION = "존재하지 않는 메뉴 번호를 입력하셨습니다.";
    public static final String WRONG_TABLE_NUMBER_EXCEPTION = "존재하지 않는 테이블 번호를 입력하셨습니다.";

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String errorMessage) {
        super(errorMessage);
    }
}
