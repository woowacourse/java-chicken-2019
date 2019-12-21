package domain.Exception;

public class MenuDoesNotExistExeption extends RuntimeException {
    private static final String MENU_DOES_NOT_EXIST_MESSAGE = "존재하지 않는 메뉴입니다.";

    public MenuDoesNotExistExeption() {
        super(MENU_DOES_NOT_EXIST_MESSAGE);
    }
}
