package service;

public class Service {
    private final int number;
    private final String name;

    Service(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + "-" + name;
    }
}
