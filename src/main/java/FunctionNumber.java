public class FunctionNumber {
    private static final int FUNCTION_MIN = 1;
    private static final int FUNCTION_MAX = 3;

    private final int functionNumber;

    public FunctionNumber(int functionNumber) {
        if (functionNumber < FUNCTION_MIN || functionNumber > FUNCTION_MAX) {
            throw new IllegalArgumentException("기능은 1, 2, 3 중에서 선택해 주세요");
        }
        this.functionNumber = functionNumber;
    }
}