package domain;

public class Order {
    private Menu menu;
    private int foodCount;

    public Order(Menu menu, int foodCount) {
        this.menu = menu;
        this.foodCount = foodCount;
    }

    public boolean isEqualMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    public void increaseFoodCount(int foodCount){
        this.foodCount += foodCount;
    }

    public int getMenuPriceByCount() {
        return menu.getPrice() * foodCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu.getName() + " ");
        sb.append(foodCount + " ");
        sb.append(menu.getPrice());
        return sb.toString();
    }
}
