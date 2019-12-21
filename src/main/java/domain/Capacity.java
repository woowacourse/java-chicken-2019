package domain;

public class Capacity {
    private static final int HUNDREAD = 100;
    private int capacity;

    public Capacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isPossibleOrder(int orderCapacity) {
        return capacity + orderCapacity > HUNDREAD;
    }

    public void addCapacity(int orderCapacity) {
        capacity += orderCapacity;
    }
}
