package domain;

public class TableMenu {

    private Menu menu;
    private Count count;

    public TableMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = new Count(count);
    }

    public void addCount(int count) {
        this.count.addCount(count);
    }

    public int calculateMoney() {
        return menu.getPrice() * count.getCount();
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count.getCount() + " " + menu.getPrice();
    }
}
