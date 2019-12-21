package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private static final double CASH_DISCOUNT_PERCENT = 0.05;
    private static final int CHICKEN_DISCOUNT_COUNT = 10;
    private static final int CHICKEN_DISCOUNT_MONEY= 10_000;
    private final int number;
    private final Map<MenuNumber, Integer> orderedMenuList = new HashMap<>();

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSameTableNumber(int tableNumber) {
        return number == tableNumber;
    }

    public void getOrderedMenu(MenuNumber menuNumber, MenuCount menuCount) {
        if (orderedMenuList.keySet().contains(menuNumber)) {
            int countSum = orderedMenuList.get(menuNumber) + menuCount.get();
            orderedMenuList.put(menuNumber, countSum);
            return;
        }
        orderedMenuList.put(menuNumber, menuCount.get());
    }

    public boolean isUnpaidTable() {
        return orderedMenuList.size() != 0;
    }

    public String getOrderedMenuList() {
        List<String> orderedMenus = new ArrayList<>();
        for (MenuNumber menuNumber : orderedMenuList.keySet()) {
            String menuName = MenuRepository.getMenuName(menuNumber);
            int menuCount = orderedMenuList.get(menuNumber);
            int menuPrice = MenuRepository.getMenuPrice(menuNumber);
            int priceSum = menuCount * menuPrice;
            orderedMenus.add(menuName+" "+menuCount+" "+priceSum);
        }
        return String.join("\n", orderedMenus);
    }

    public double calculateOrderedMenuPriceSum(PaymentMethod paymentMethod) {
        int orderedMenuPriceSum = 0;
        for (MenuNumber menuNumber : orderedMenuList.keySet()) {
            int menuCount = orderedMenuList.get(menuNumber);
            int menuPrice = MenuRepository.getMenuPrice(menuNumber);
            int priceSum = menuCount * menuPrice;
            orderedMenuPriceSum += priceSum;
        }
        orderedMenuPriceSum -= calculateChickenDiscountSum();
        if (paymentMethod.isCash()) {
            orderedMenuPriceSum -= orderedMenuPriceSum * CASH_DISCOUNT_PERCENT;
        }
        return orderedMenuPriceSum;
    }

    private int calculateChickenDiscountSum() {
        int chickenCount = 0;
        for (MenuNumber menuNumber : orderedMenuList.keySet()) {
            chickenCount = MenuRepository.getChickenCount(menuNumber);
        }
        return (chickenCount / CHICKEN_DISCOUNT_COUNT) * CHICKEN_DISCOUNT_MONEY;
    }

    public void clearOrderedMenuList() {
        orderedMenuList.clear();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
