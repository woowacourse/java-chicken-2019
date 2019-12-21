package domain;

/**
 * 음식 메뉴를 의미하는 객체
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
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

    public boolean isSameNumber(int menuNumber) {
        return number == menuNumber;
    }

    public boolean isChicken() {
        return Category.CHICKEN.equals(category);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int calculatePrice(int count) {
        return price * count;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
