package exceptions;

public enum CustomException {
    NOT_VALID_INPUT_OF_MAIN_UI("1,2,3 중 하나를 입력해주세요."),
    NOT_VALID_INPUT_OF_TABLE_NUMBER("등록된 테이블 중 하나를 입력해주세요."),
    NOT_VALID_INPUT_OF_MENU_NUMBER("등록된 메뉴 중 하나를 입력해주세요."),
    NOT_VALID_INPUT_OF_MENU_QUANTITY("1-99의 자연수를 입력해주세요."),
    OVER_MAX_MENU_QUANTITY("해당 메뉴의 주문수량이 총 100개 이상이기 때문에 주문할 수 없습니다."),
    ALREADY_FULLY_ORDERED_MENU("이미 해당 메뉴를 99개 주문하셨기 때문에 주문할 수 없습니다.");

    private String errMessage;

    CustomException(String errMessage) {
        this.errMessage = errMessage;
    }

    protected String getErrMessage() {
        return this.errMessage;
    }
}
