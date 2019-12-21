package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private static final int DISCOUNT_AMOUNT = 10000;
    private static final int DISCOUNT_MEASURE = 10;
    private static final int ZERO = 0;
    private final int number;
    private List<OrderedMenu> menus = new ArrayList<>();
    private int totalMoney = 0;

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public List<OrderedMenu> getMenus() {
        return menus;
    }

    public void addMenu(Table table, Menu menu, int howMany) {
        menus.add(new OrderedMenu(table, menu, howMany));
    }

    private double sumOfMenus() {
        int chickenCount = ZERO;
        for (OrderedMenu menu : menus) {
            chickenCount = getChickenCount(chickenCount, menu);
            totalMoney += menu.sumOfEachMenu();
        }
        int chickenAmountForDiscount = chickenCount % DISCOUNT_MEASURE;
        return totalMoney - (chickenAmountForDiscount * DISCOUNT_AMOUNT);
    }

    private int getChickenCount(int chickenCount, OrderedMenu menu) {
        if (menu.isChicken(menu.getMenuId()))
            chickenCount++;
        return chickenCount;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public double getTotalMoneyWithPayment(Payment payment) {
        return payment.calculateWithPayment(sumOfMenus());
    }
}
