package domain;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> orderList = new ArrayList<>();
    private PoS posForThisTable = new PoS();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addOrder(Menu newMenu) throws SizeLimitExceededException {
        if (checkSize())
            throw new SizeLimitExceededException("입력 가능한 메뉴의 최대 개수를 초과했습니다.");

        orderList.add(newMenu);
    }

    private boolean checkSize() {
        final int menuSizeLimit = 99;
        if (orderList.size() >= menuSizeLimit) {
            orderList.clear();
            return true;
        }

        return false;
    }

    public boolean hasOrder() {
        return !orderList.isEmpty();
    }

    public void startCheckout() {
        printOrderList();
        int checkoutPrice = posForThisTable.startCheckout(orderList, number);
        if (checkoutPrice < 0) {
            System.out.println("최종 결제 금액이 음수입니다. 기존 주문 정보를 초기화합니다.");
        }
        System.out.println("## 최종 결제 금액");
        System.out.println(checkoutPrice + "원\n");
        orderList.clear();
    }

    private void printOrderList() {
        System.out.println("## 주문 내역\n메뉴\t수량\t금액");
        for (Menu it : orderList) {
            System.out.println(it.toString());
        }
        System.out.println();
        System.out.println("## " + number + "번 테이블의 결제를 진행합니다.");
    }

}
