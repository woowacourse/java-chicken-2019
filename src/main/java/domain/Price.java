package domain;

public class Price {
    private final int price;

    public Price(int price) {
        this.price = price;
    }

    protected Price addPrice(Menu menu, int amount) {
        int newPrice = menu.getPrice()*amount;
        return new Price (this.price + newPrice);
    }

    public int getPrice(boolean isCash) {
        if(isCash) {
            return (int)(0.95 * (double) this.price);
        }
        return this.price;
    }
}
