package domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int tableNumber;
    private List<Menu> orderMenu = new ArrayList<>();
    private int money = 0;

    public Customer(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}