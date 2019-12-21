package domain;

public class Pay {
    private int countMenu;
    private final int tableNumber;
    private int tablePay = 0;

    public Pay(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTablePay(int morePay) {
        tablePay += morePay;
    }

}
