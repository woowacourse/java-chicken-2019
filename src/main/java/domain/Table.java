package domain;

public class Table {
    private final int number;
    private TableStatus tableStatus;

    public Table(final int number) {
        this.number = number;
        tableStatus = TableStatus.Wating;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    //todo: do other logic
    public void takeAnOrder() {
        tableStatus = TableStatus.Registered;
    }

    //todo: do other logic
    public void getSettled() {
        tableStatus =  TableStatus.Wating;
    }
}
