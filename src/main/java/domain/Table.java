package domain;

public class Table {
    private final int number;
    private OrderList orderList = new OrderList();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public Boolean isItInt(Integer input) {
        if (input.equals(this.number)) {
            return true;
        }
        return false;
    }

    public void setOrder(Menu menu) {
        orderList.setOrder(menu);
    }
}