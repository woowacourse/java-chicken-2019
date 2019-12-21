package domain;

public class Table {
    private final int number;
    private OrderStorage orders = new OrderStorage();
    private boolean isOrdered = false;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public void enterOrder() {
    	orders.enterNewOrder();
    	this.isOrdered = true;
    }
    
    public OrderStorage getOrders() {
    	return this.orders;
    }
    
    public String convertStateToSTring() {
    	if (this.isOrdered) {
    		return "└ \\ ┘";
    	}
    	return "└ ─ ┘";
    }
}
