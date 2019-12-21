package domain;

public class Menu {
    private final MenuNumber number;
    private final MenuName name;
    private final Category category;
    private final MenuPrice price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = new MenuNumber(number);
        this.name = new MenuName(name);
        this.category = category;
        this.price = new MenuPrice(price);
    }

    public boolean isSameMenuNumber(int number) {
        return this.number.getNumber() == number;
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    @Override
    public String toString() {
        return category + " " +
                number.getNumber() + " - " +
                name.getName() + " : " +
                price.getPrice() + "원";
    }
}
