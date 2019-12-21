package domain;

public class Capacity {
    int capacity;

    public Capacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isPossibleOrder(int orderCapacity) {
        return capacity + orderCapacity < 100;
    }

    public Capacity addCapacity(int orderCapacity) {
        return new Capacity(capacity + orderCapacity);
    }
}
