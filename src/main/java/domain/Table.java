package domain;

import java.util.HashMap;

public class Table {
    private final int number;
    private HashMap<Integer,Integer> orders = new HashMap<Integer, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber(){
        return number;
    }

    public void addOrder(int menuNumber, int menuCount){
        orders.put(menuNumber,menuCount);
    }

    public HashMap<Integer, Integer> getOrder(int tableNumber){
        if (number == tableNumber){
            return orders;
        }
        return new HashMap<>();//임시 리턴
    }
}
