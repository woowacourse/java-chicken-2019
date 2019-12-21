package domain;

public class Table {
    private final int number;
    private int chickenNumber=0;
    private int chickenPrice=0;
    private int drinkNumber=0;
    private int drinkPrice=0;

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
    
    public void setChickenPrice(int chickenNum,int chickenPrice) {
	this.chickenNumber+=chickenNum;
	this.chickenPrice+= chickenNum*chickenPrice;
    }
    
    public void setDrinkPrice(int drinkNum,int drinkPrice) {
	this.drinkNumber+=drinkNum;
	this.drinkPrice+=drinkNum*drinkPrice;
    }
}
