package domain;

public class Table {
    private final int number;
    private final MenuQuantity menuQuantity = new MenuQuantity(MenuRepository.menus());

    public Table(final int number) {
        this.number = number;
    }

    public Boolean isMatchingTable(int tableNumber) {
        return this.number == tableNumber;
    }

    public Boolean canAddMenuQuantity(Menu menu, int quantity) {
        return menuQuantity.canAddMenuQuantity(menu, quantity);
    }

    public void addMenuQuantity(Menu menu, int quantity) {
        menuQuantity.addMenuQuantity(menu, quantity);
    }

    public Boolean isOrderedTable() {
        return menuQuantity.isOrdered();
    }

    public Boolean IsAlreadyFullyOrdered(Menu menu) {
        return menuQuantity.IsAlreadyFullyOrdered(menu);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
