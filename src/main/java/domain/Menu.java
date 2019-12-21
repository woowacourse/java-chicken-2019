package domain;

/**
 * @author : Kim SeYun
 * @ClassName : Menu
 * @ClassExplanation : 메뉴 객체
 * @Date : 2019. 12. 21
 * @Copyright (c) 2019 SeYun Kim
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

    @Override
    public String toString() {
        return name + " " + number + " " + price;
    }

    public boolean menuInputCheck(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() { return price; }

    public String getName() { return name; }
}
