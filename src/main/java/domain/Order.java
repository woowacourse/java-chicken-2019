package domain;

public class Order {
    private int foodNumber;
    private int foodCount;

    public Order(int foodNumber, int foodCount) {
        this.foodNumber = foodNumber;
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(foodNumber);
        sb.append(foodCount);
        return sb.toString();
    }
}
