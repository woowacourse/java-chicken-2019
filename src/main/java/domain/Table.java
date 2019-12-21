package domain;

public class Table {
    private final int number;
    private int chickenNumber;
    private int drinkNumber;

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
}
