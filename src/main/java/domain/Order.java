package domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Table table;
    private Menus menus;

    public Order(Table table, Menus menus) {
        this.table = table;
        this.menus = menus;
    }
}
