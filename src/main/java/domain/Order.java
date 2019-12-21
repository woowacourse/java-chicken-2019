package domain;

public class Order {
    private static final int ZERO = 0;
    private static final String SPACE = " ";

    private Menu menu;
    private int foodCount;

    public Order(Menu menu, int foodCount) {
        this.menu = menu;
        this.foodCount = foodCount;
    }

    public boolean isEqualMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    public void increaseFoodCount(int foodCount) {
        this.foodCount += foodCount;
    }

    public int getMenuPriceByCount() {
        return menu.getPrice() * foodCount;
    }

    public int getFoodCountWhenChicken() {
        if (menu.isMatchCategory(Category.CHICKEN)) {
            return foodCount;
        }
        return ZERO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(menu.getName() + SPACE);
        sb.append(foodCount + SPACE);
        sb.append(menu.getPrice());
        return sb.toString();
    }
}
