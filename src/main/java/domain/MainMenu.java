package domain;

public class MainMenu {

    private static final int ORDER_MENU_NUMBER = 1;
    private static final int PAY_MENU_NUMBER = 2;
    private static final int QUIT_MENU_NUMBER = 3;

    private int number;
    private String name;

    MainMenu(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public boolean isSameMenu(int number) {
        return this.number == number;
    }

    public boolean isOrder() {
        return this.number == ORDER_MENU_NUMBER;
    }

    public boolean isPay() {
        return this.number == PAY_MENU_NUMBER;
    }

    public boolean isQuit() {
        return this.number == QUIT_MENU_NUMBER;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }

}
