package domain;

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

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public boolean isMenu(int value) {
        return this.number == value;
    }

    /**
     * 주문양에 대한 금액을 계산합니다.
     *
     * @param MenuQuantity 주문수량
     * @return 주문에 대한 총금액
     */
    public int calculate(int MenuQuantity) {
        return MenuQuantity * (this.price);
    }
}
