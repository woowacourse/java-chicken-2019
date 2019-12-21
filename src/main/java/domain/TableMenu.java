package domain;

public class TableMenu {

    private Menu menu;
    private int count;

    public TableMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int calculateMoney() {
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + " " + calculateMoney();
    }
}
