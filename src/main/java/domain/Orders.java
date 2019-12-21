package domain;

import java.util.List;

public class Orders {
    private final List<Menu> orders;

    public Orders(List<Menu> orders) {
        this.orders = orders;
    }

    public int chickenSize() {
        return (int) orders.stream()
                .filter(Menu::isChicken)
                .count();
    }

    public int getPrice() {
        return orders.stream()
                .map(Menu::getPrice)
                .reduce(0, Integer::sum);
    }

}
