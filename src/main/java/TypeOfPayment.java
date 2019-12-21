public class TypeOfPayment {
    private static final int CASH = 1;
    private static final int CREDIT_CARD = 2;

    private final int typeOfPayment;

    public TypeOfPayment(int typeOfPayment) {
        if (typeOfPayment != CASH && typeOfPayment != CREDIT_CARD) {
            throw new IllegalArgumentException("결제는 현금 아니면 카드만 가능합니다.");
        }
        this.typeOfPayment = typeOfPayment;
    }
}