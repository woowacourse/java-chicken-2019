package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isChicken() {
        return category.equals(Category.CHICKEN);
    }

    public int getPrice() {
        return price;
    }

    public boolean equalId(int id) {
        return number == id;
    }

    public List<Menu> list(int size) {
        List<Menu> orders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            orders.add(this);
        }
        return orders;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
