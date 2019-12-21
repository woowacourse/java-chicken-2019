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

    public boolean isExist(int menuNumber){
        if(number == menuNumber)
            return true;
        return false;
    }

    public int getNumber() {
        return number;
    }

    public Menu getMenu(int menuNumber){
        if(menuNumber == number)
            return this;
        throw new IllegalArgumentException("그런메뉴는 존재하지 않습니다.");
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
