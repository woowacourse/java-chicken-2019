package domain;

public class Order {
    public static final int MAX = 99;
    public static final int MIN = 1;
    private final Menu menu;
    private final int amount; // 수량

    public Order(Menu menu, int amount) {
        if (amount > 99) {
            throw new IllegalArgumentException("한 메뉴의 최대 수량은 99개 입니다.");
        }
        if (amount < 1) {
            throw new IllegalArgumentException("한 메뉴의 수량은 1이상이어야 합니다.");
        }
        this.menu = menu;
        this.amount = amount;
    }

    public int price()
    {
        return menu.price() * amount;
    }

    public boolean isChicken() {
        return menu.isChicken();
    }

    public int amount() {
        return amount;
    }

    public String toString() {
        return menu.name() + ' ' + amount + ' ' + price();
    }
}
