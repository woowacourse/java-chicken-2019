package domain;

public class Pay {
    private final static int CHICKEN_SALE = 10000;
    private final static int CHICKEN_SALE_COUNT = 10;
    private final static double CASH_SALE_RATE = 0.95;
    static int total = 2;
    static int chickenCount = 10;

    public static int totalCreditPay(){
        return total - (chickenCount/CHICKEN_SALE_COUNT) * CHICKEN_SALE;
    }
    public static double totalCashPay(){
        return (total - (chickenCount/CHICKEN_SALE_COUNT)* CHICKEN_SALE)*CASH_SALE_RATE;
    }
    public static double CashOrCredit(int chooseMethod){
        if (chooseMethod == 1){
            return (double) totalCreditPay();
        }
        return totalCashPay();
    }


}
