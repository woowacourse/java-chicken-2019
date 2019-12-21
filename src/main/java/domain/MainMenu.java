package domain;

public class MainMenu {
    private final int actionNumber;
    private final String actionName;

    public MainMenu(int actionNumber, String actionName) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;

    }

    @Override
    public String toString() {
        return actionNumber + " - " + actionName;
    }

    public boolean isEqualNumber(int inputNumber) {
        return this.actionNumber == inputNumber;
    }
}
