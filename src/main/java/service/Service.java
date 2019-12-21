package service;

import domain.Table;

import java.util.List;

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

    public boolean isCalled(int number) {
        return this.number == number;
    }

    public void run(List<Table> tables) {
    }

}
