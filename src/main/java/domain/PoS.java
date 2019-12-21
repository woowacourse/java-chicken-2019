package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class PoS {
    private static DiscountPolicy policy = new DiscountPolicy();

    public void lookUpOrderList(List<Menu> menuList) {
        OutputView.printMenus(menuList);
    }

    public int startCheckout(List<Menu> menuList, int tableNumber) {
        int hisPaymentType = InputView.inputPaymentMethod(tableNumber);
        return calcFinalPrice(menuList, checkPaymentMethod(hisPaymentType));
    }

    private boolean checkPaymentMethod(int hisPaymentType) {
        if (PaymentType.CASH.equals(hisPaymentType))
            return true;
        return false;
    }

    private int calcTotalPrice(List<Menu> menuList) {
        int totalPrice = 0;
        for (Menu it : menuList)
            totalPrice += it.getPrice();
        return totalPrice;
    }

    private int calcFinalPrice(List<Menu> menuList, boolean isCash) {
        return Math.round((calcTotalPrice(menuList) - policy.QuantityDiscount(menuList))
                * policy.cashDiscount(isCash));
    }


}
