package domain;

public class TableMenu {

    private Menu menu;
    private Count count;

    TableMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = new Count(count);
    }

    void addCount(int count) {
        this.count.addCount(count);
    }

    boolean isSameMenu(Menu menu) {
        return this.menu.isSameMenu(menu.getNumber());
    }

    int calculateMoney() {
        return menu.getPrice() * count.getCount();
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count.getCount() + " " + menu.getPrice();
    }
}
