package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class PoS {
    private static DiscountPolicy policy = new DiscountPolicy();

    public void lookUpOrderList(List<Menu> orderList) {
        OutputView.printMenus(orderList);
    }

    public int startCheckout(List<Menu> orderList, int tableNumber) {
        int hisPaymentType = InputView.inputPaymentMethod(tableNumber);
        return calcFinalPrice(orderList, checkPaymentMethod(hisPaymentType));
    }

    private boolean checkPaymentMethod(int hisPaymentType) {
        if (PaymentType.CASH.equals(hisPaymentType))
            return true;
        return false;
    }

    private int calcTotalPrice(List<Menu> orderList) {
        int totalPrice = 0;
        for (Menu it : orderList)
            totalPrice += it.getPrice();
        System.out.println("## 총 청구액: " + totalPrice);
        return totalPrice;
    }

    private int calcFinalPrice(List<Menu> orderList, boolean isCash) {
        int originalPrice = calcTotalPrice(orderList);
        int quantityDiscount = policy.QuantityDiscount(orderList);
        int totalPrice =
                Math.round((originalPrice - quantityDiscount) * policy.cashDiscount(isCash));
        if (totalPrice < 0)
            throw new IllegalArgumentException("결제액이 음수입니다.");
        System.out.println("## 할인액: " + (originalPrice - totalPrice));
        return totalPrice;
    }


}
