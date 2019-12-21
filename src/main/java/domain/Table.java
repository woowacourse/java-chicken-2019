package domain;

public class Table {
    private final int number;
    private static int orderedMenuNumber;
    public Table(final int number) {
        this.number = number;
    }

    public int getOrderedMenuNumber(){
        return orderedMenuNumber;
    }

    public boolean getTable(int tableNumber){
        if(tableNumber == number){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
