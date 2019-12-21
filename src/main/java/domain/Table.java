package domain;

public class Table {
    private final int number;
    private boolean isInUse;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isInUse() {
        return this.isInUse;
    }

    public void changeToInUse() {
        this.isInUse = true;
    }

    public void changeToNotInUse() {
        this.isInUse = false;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
