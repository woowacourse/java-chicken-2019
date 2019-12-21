package domain.menu;

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

    public boolean isRightMenuNumber(int menuCode) {
        return menuCode == number;
    }

    /**
     * getPrice는 메뉴의 가격을 반환하는 getter 메서드이다.
     *
     * @return 이 메뉴의 가격을 반환한다.
     */
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
