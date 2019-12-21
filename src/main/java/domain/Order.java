package domain;

public class Order {
    private Menu menu;
    private int foodCount;

    public Order(Menu menu, int foodCount) {
        this.menu = menu;
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu);
        sb.append(foodCount);
        return sb.toString();
    }
}
