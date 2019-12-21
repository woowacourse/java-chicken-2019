package domain;

public interface OrderService {
    int getTotalCost();

    int getChickenQuantity();

    void changeQuantity(Menu menu, int quantityToAdd);
}
