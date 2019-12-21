package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean TableInputCheck(int number) {
        if(this.number == number){
            return true;
        }
        return false;
    }
}
