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
        if (existMenu.canOrderMore(howMany)) {
            existMenu.addJustCount(howMany);
        }
        if (!existMenu.canOrderMore(howMany)) {
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
        return totalMoney - chickenAmountForDiscount;   // 현금 할인율이 적용되지 않은 Sum을 구하는 메서드입니다.
    }

    private int getChickenCount(int chickenCount, OrderedMenu menu) {
        if(menu.isChicken(menu.getMenuId())){
            chickenCount += menu.getCount();
        }
        totalMoney += menu.sumOfEachMenu();
        return chickenCount;    //  치킨 수를 통해, 할인을 하기위한 메서드입니다.
    }

    public double getTotalMoneyWithPayment(Payment payment) {
        return payment.calculateWithPayment(sumOfMenus());  //  현금 할인 여부까지 정의된 총 금액입니다.
    }


    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
