package exceptions;

public enum CustomException {
    NOT_VALID_INPUT_OF_MAIN_UI("1,2,3 중 하나를 입력해주세요.");

    private String errMessage;

    CustomException(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return this.errMessage;
    }
}
