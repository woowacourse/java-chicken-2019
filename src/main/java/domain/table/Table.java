package domain.table;

import domain.table.order.Basket;

import java.util.ArrayList;
import java.util.List;

import static util.ErrorMessage.INVALID_MENU_NUMBER;

public class Table {
    private final Integer number;
    private List<Basket> baskets = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void saveBasket(final Basket basket) {
        if (checkExistBasketMenu(basket)) {
            editBasket(basket);
            return;
        }
        baskets.add(basket);
    }

    public void editBasket(final Basket otherBasket) {
        Basket basketSameMenu = findBasketSameMenu(otherBasket);
        basketSameMenu.plusCountMenu(otherBasket.getCountMenuNumber());
    }

    public Basket findBasketSameMenu(Basket otherBasket) {
        return baskets.stream()
                .filter(b -> b.isSameMenu(otherBasket))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INVALID_MENU_NUMBER);
                });
    }

    public Integer getTableCharge() {
        return baskets.stream()
                .mapToInt(Basket::getCharge)
                .sum();
    }

    private boolean checkExistBasketMenu(Basket otherBasket) {
        return baskets.stream()
                .anyMatch(b -> b.isSameMenu(otherBasket));
    }

    public Integer getNumber() {
        return number;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void successPayProcessing() {
        baskets.clear();
    }

    public boolean isPayProcessingRequire() {
        return !baskets.isEmpty();
    }
}
