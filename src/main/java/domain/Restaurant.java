package domain;

import java.util.HashMap;
import java.util.Map;

public class Restaurant implements RestaurantService {
    private Map<Table, Order> restaurant;

    public Restaurant() {
        this.restaurant = new HashMap<>();
        for (Table table : TableRepository.tables()) {
            this.restaurant.put(table, new Order());
        }
    }

    @Override
    public void clearTable(Table table) {
        restaurant.put(table, new Order());
    }
}
