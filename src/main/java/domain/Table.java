package domain;

import java.util.ArrayList;
import java.util.List;

import view.OutputView;

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

    public boolean hasMenu() {
        return menus.size() != ZERO;
    }

    public boolean addMenu(Table table, Menu menu, int howMany) {
        OrderedMenu orderMenu = new OrderedMenu(table, menu, howMany);
        if (menus.stream().anyMatch(s -> s.equals(orderMenu))) {
            return alreadyHasTheMenu(howMany, orderMenu);   //  이미, 주문 한 상품의 경우
        }
        menus.add(orderMenu);   // 처음 주문하는 상품의 경우
        return false;
    }

    private boolean alreadyHasTheMenu(int howMany, OrderedMenu orderMenu) {
        OrderedMenu existMenu = menus.stream()
                .filter(s -> s.equals(orderMenu)).findFirst().get();
        if (existMenu.canOrder(howMany)) {
            existMenu.addJustCount(howMany);
        }
        if (!existMenu.canOrder(howMany)) {
            OutputView.printAmountError();
        }
        return true;
    }

    private double sumOfMenus() {
        int chickenCount = ZERO;
        for (OrderedMenu menu : menus) {
            chickenCount = getChickenCount(chickenCount, menu);
        }
        int chickenAmountForDiscount = (chickenCount / DISCOUNT_MEASURE) * DISCOUNT_AMOUNT;
        return totalMoney - chickenAmountForDiscount;
    }

    private int getChickenCount(int chickenCount, OrderedMenu menu) {
        if(menu.isChicken(menu.getMenuId())){
            chickenCount += menu.getCount();
        }
        totalMoney += menu.sumOfEachMenu();
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
