package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class Payment {
    static final int DISCOUNT_PER_10CHICKEN = 10000;
    Table table;
    int paymentMethod; // 1: 신용카드, 2: 현금

    public Payment(Table table) {
        if (table == null)
            throw new IllegalArgumentException("테이블이 잘못되었습니다.");
        this.table = table;
    }

    public void pay() {
        if (!validateOrderedMenu())
            return;
        printOrderdList();

        paymentMethod = getPaymentMethod();
        int finalPrice = getFinalPrice();

        OutputView.printTotalPayPrice(finalPrice);
        table.clearMenus();
    }

    public int getFinalPrice(){
        int finalPrice  = table.getTotalPrice();
        finalPrice -= getChickenDiscount();
        if (paymentMethod == 2)
            finalPrice = getCashDiscount(finalPrice);
        return finalPrice;
    }

    public int getPaymentMethod() {
        String input;
        do {
            input = InputView.inputPaymentMethod(table);
        } while (!validatePaymentMethod(input));

        return Integer.parseInt(input);
    }

    public boolean validatePaymentMethod(String input) {
        int paymetMethod = Validate.validateNumber(input);
        if (paymetMethod == 1 || paymetMethod == 2)
            return true;
        System.out.println("주문 방식을 잘못 입력하셨습니다.\n");
        return false;
    }

    public int getChickenDiscount() {
        int chickenCount = table.getChickenCount();
        int discount = chickenCount / 10;
        return discount * DISCOUNT_PER_10CHICKEN;
    }

    private int getCashDiscount(int totalPrice) {
        return  (int) (totalPrice * 0.95);
    }

    private boolean validateOrderedMenu() {
        if (table.getTableMenuCount() <= 0) {
            System.out.println("주문 내역이 없습니다.\n");
            return false;
        }
        return true;
    }

    private void printOrderdList() {
        OutputView.printOrderedMenuInfo();
        final List<Menu> menus = MenuRepository.menus();
        for (int i = 0; i < menus.size(); i++)
            if (table.getMenus().contains(menus.get(i))){
                int menuCount = table.getMenuCount(menus.get(i));
                OutputView.printOrderedMenu(menus.get(i), menuCount);
            }
    }
}
