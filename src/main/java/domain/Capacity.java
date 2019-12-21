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
        return capacity + orderCapacity > 100;
    }

    public void addCapacity(int orderCapacity) {
        capacity += orderCapacity;
    }
}
