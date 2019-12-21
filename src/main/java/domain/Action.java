package domain;

public class Action {
    private final int number;
    private final String name;

    public Action(final int number, final String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return Integer.toString(number) + " - " + name;
    }
}
