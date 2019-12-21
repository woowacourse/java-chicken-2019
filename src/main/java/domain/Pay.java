/*
 * Pay
 *
 * ver 1.0
 *
 * 2019.12.21
 *
 * CopyRight
 *
 */
package domain;

import java.util.ArrayList;
import java.util.List;


public class Pay {
    private int countMenu = 0; // 총 치킨을 시킨 카운트
    private final int tableNumber; // 테이블 번호
    private int tablePay = 0; // 테이블 총 금액
    private static final List<String> orderedMenu = new ArrayList<>(); // 주문한 메뉴의 이름
    private static final List<Integer> orderedMenuCount = new ArrayList<>(); // 주문한 메뉴의 카운트
    private static final List<Integer> orderedMenuCost = new ArrayList<>(); // 주문한 해당 메뉴의 총 금액
    /*
     * Pay 클래스 입니다.
     * 테이블당 유저가 주문한 금액 및 데이터들을 모두 저장해서 가지고 있는 클래스입니다.
     */
    public Pay(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getTablePay() {
        return tablePay;
    }

    public void setMenus(String menu, int cost) {
        int index = orderedMenu.indexOf(menu);
        if(index != -1) {
            orderedMenuCount.set(index,orderedMenuCount.get(index)+1);
            orderedMenuCost.set(index,orderedMenuCost.get(index)+cost);
        } else {
            orderedMenu.add(menu);
            orderedMenuCount.add(1);
            orderedMenuCost.add(cost);
        }
    }

    public void setTablePay(int morePay) {
        tablePay += morePay;
    }

    public void plusCount(int menuNumber) {
        if (menuNumber < 7) {
            countMenu += 1;
        }
    }

    public int getCount() {
        return countMenu;
    }

    public int searchCount(String menu) {
        int count = 0;
        int index = orderedMenu.indexOf(menu);
        if(index != -1) {
            count = orderedMenuCount.get(index);
        }
        return count;
    }

    public List<String> getOrderedMenu() { // 메뉴의 현 상황을 돌려 받는다.
        List<String> finalMenu = new ArrayList<>();
        for (int index = 0; index < orderedMenu.size(); index++) {
            String result = orderedMenu.get(index) + " " + orderedMenuCount.get(index) + " " + orderedMenuCost.get(index);
            finalMenu.add(result);
        }
        return finalMenu;
    }

    public void resetTable() { // 결제 완료후 리셋을 시킨다.
        tablePay = 0;
        countMenu = 0;
        orderedMenu.clear();
        orderedMenuCost.clear();
        orderedMenuCount.clear();
    }
}
