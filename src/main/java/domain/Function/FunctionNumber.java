package domain.Function;

public class FunctionNumber {
    private static final int REGISTER_ORDER = 1;
    private static final int PAY_ORDER = 2;
    private static final int EXIT = 3;

    private final int functionNumber;

    public FunctionNumber(int functionNumber) {
        validateFunctionNumber(functionNumber);
        this.functionNumber = functionNumber;
    }

    private void validateFunctionNumber(int functionNumber) {
        if (!isValidValue(functionNumber)) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    private boolean isValidValue(int functionNumber) {
        return functionNumber == REGISTER_ORDER || functionNumber == PAY_ORDER || functionNumber == EXIT;
    }

    public boolean isRegisterOrder() {
        return this.functionNumber == REGISTER_ORDER;
    }

    public boolean isPayOrder() {
        return this.functionNumber == PAY_ORDER;
    }

    public boolean isExit() {
        return this.functionNumber == EXIT;
    }
}
