package domain;

public enum Payment {
    CREDIT_CARD(1,1),
    CASH(2,0.95);

    private final int id;
    private final double discount;

    Payment(int id, double discount) {
        this.id = id;
        this.discount = discount;
    }

    public double calculateWithPayment(double totalMoney){
        if(id == CREDIT_CARD.id){
            return totalMoney * CREDIT_CARD.discount;
        }
        return totalMoney * CASH.discount;
    }
}
