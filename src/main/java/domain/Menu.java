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

    public int totalPay(int count) {
        return price * count;
    }

    public int isChicken() {                //지금 들어온 주문이 치킨인지 확인
        if(category == Category.CHICKEN) {
            return 1;
        }
        return 0;
    }

    public String printMenu(int count) {
        return name + " " + count + " " + (price * count);
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
