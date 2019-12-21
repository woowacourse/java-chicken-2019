package domain;

public class Table {
    private static final int TABLE_MIN = 1;
    private static final int INITIAL_VALUE = 0;

    private final int number;
    private Payment paymentAmount;
    private String orderHistory;

    public Table(final int number) {
        if (number < TABLE_MIN) {
            throw new IllegalArgumentException("테이블 숫자는 " + TABLE_MIN + "이상이어야 합니다.");
        }
        this.number = number;
        this.paymentAmount = new Payment(INITIAL_VALUE, INITIAL_VALUE);
        this.orderHistory = "";
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addMenuOrder(final int menuNumber, final int orderAmount) {
        Menu menu = MenuRepository.getMenu(menuNumber);
        this.orderHistory += menu.getOrderString(orderAmount);
        if (menu.isChicken()) {
            this.paymentAmount = this.paymentAmount.addPaymentAmount(menu.getAmountPrice(orderAmount), orderAmount);
            return;
        }
        this.paymentAmount = this.paymentAmount.addPaymentAmount(menu.getAmountPrice(orderAmount), 0);
    }

    public int calculatePaymentAmount(final int paymentMethod) {
        int paymentAmount = this.paymentAmount.calculateFinalPaymentAmount(paymentMethod);
        resetTable();
        return paymentAmount;
    }

    public void resetTable() {
        this.paymentAmount = new Payment(INITIAL_VALUE, INITIAL_VALUE);
        this.orderHistory = "";
    }

    public boolean isSameNumber(final int number) {
        return this.number == number;
    }

    public String getOrderHistory() {
        return this.orderHistory;
    }

    public boolean isBeforePayment() {
        return orderHistory.equals("");
    }
}
