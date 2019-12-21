package domain;

public class Order {
	private final Menu menu;
	private final MenuCount menuCount;
	
    public Order(final Menu menu, final MenuCount menuCount) {
        this.menu = menu;
        this.menuCount = menuCount;
    }
}
