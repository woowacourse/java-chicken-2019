package domain;

public interface RestaurantService {
    Order getOrder(Table table);

    void orderMenu(Table table, int menuNumber, int quantityToAdd);

    void clearTable(Table table);
}
