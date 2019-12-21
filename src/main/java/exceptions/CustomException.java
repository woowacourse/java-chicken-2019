package exceptions;

public enum CustomException {
    NOT_VALID_INPUT_OF_MAIN_UI("1,2,3 중 하나를 입력해주세요."),
    NOT_VALID_INPUT_OF_TABLE_NUMBER("등록된 테이블 중 하나를 입력해주세요."),
    NOT_VALID_INPUT_OF_MENU_NUMBER("등록된 메뉴 중 하나를 입력해주세요.");

    private String errMessage;

    CustomException(String errMessage) {
        this.errMessage = errMessage;
    }

    protected String getErrMessage() {
        return this.errMessage;
    }
}
