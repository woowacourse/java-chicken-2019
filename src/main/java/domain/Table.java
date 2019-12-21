package domain;

public class Table {
    private final int number;
    private int[] chicken= new int[6];
    private int chickenPrice=0;
    private int[] drink=new int[2];
    private int drinkPrice=0;
    private boolean order=false;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    
    public boolean isMax() {
	if(getNumberSum()>99) {
	    return true;
	}
	return false;
    }
    
    public int getNumber() {
	return this.number;
    }
    
    public int getNumberSum() {
	int sum=0;
	for(int i=0;i<6;i++) {
	    sum+=chicken[i];
	}
	for(int i=0;i<2;i++) {
	    sum+=drink[i];
	}
    	return sum;
    }
    
    public int[] getChickenMenu() {
	return chicken;
    }
    
    public int[] getDrinkMenu() {
	return drink;
    }

    public int getChickenPrice() {
	return this.chickenPrice;
    }
    
    public int getDrinkPrice() {
	return this.drinkPrice;
    }
    
    public boolean getOrderd() {
	return this.order;
    }
    
    public void setChickenPrice(int menuNum,int chickenNum,int chickenPrice) {
	this.chicken[menuNum-1]+=chickenNum;
	this.chickenPrice+= chickenNum*chickenPrice;
	this.order=true;
    }
    
    public void setDrinkPrice(int menuNum,int drinkNum,int drinkPrice) {
	this.drink[menuNum-21]+=drinkNum;
	this.drinkPrice+=drinkNum*drinkPrice;
	this.order=true;
    }
}
