package domain;

public class MenuPrice {
    private int price;

    public MenuPrice(int price) {
        validatePlus(price);
        this.price = price;
    }

    private void validatePlus(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 음수가 될 수 없습니다.");
        }
    }

    public int getPrice() {
        return price;
    }
}
