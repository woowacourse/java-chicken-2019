package domain;

public class Table {
    private final int number;
    private int chickenNumber;
    private int chickenPrice;
    private int drinkNumber;
    private int drinkPrice;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public boolean isMax() {
	if(chickenNumber+drinkNumber>99) {
	    return true;
	}
	return false;
    }
    
    public int getNumberSum() {
    	return chickenNumber+drinkNumber;
    }
    
}
