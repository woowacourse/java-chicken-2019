public class FunctionNumber {
    private static final int REGISTER_ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int EXIT = 3;

    private final int functionNumber;


    public FunctionNumber(int functionNumber) {
        if (functionNumber != REGISTER_ORDER && functionNumber != PAYMENT
                && functionNumber != EXIT) {
            throw new IllegalArgumentException("기능은 1, 2, 3 중에서 선택해 주세요");
        }
        this.functionNumber = functionNumber;
    }

    public boolean isRegisterOrder(){
        return functionNumber == REGISTER_ORDER;
    }

    public boolean isPayment(){
        return functionNumber == PAYMENT;
    }

    public boolean isExit() {
        return functionNumber == EXIT;
    }
}