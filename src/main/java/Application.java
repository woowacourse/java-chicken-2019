import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO 구현 진행
    private static int ORDER_KEY = 1;
    private static int PAY_KEY = 2;
    private static int QUIT_KEY = 3;
    private static int CARD_KEY = 1;
    private static int CASH_KEY = 2;
    private final static int CHICKEN_SALE = 10000;
    private final static int CHICKEN_SALE_COUNT = 10;
    private final static double CASH_SALE_RATE = 0.95;

    static int actionNumber = 0;
    static int payMethod = 0;
    static double totalPay = 0;
    static int totalChickenCount = 0;
    static int nowTableNumber = -1;
    static int nowMenuCategory = -1;

    final static List<Table> tables = TableRepository.tables();
    final static List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while (true) {
            OutputView.printAction();
            actionNumber = InputView.inputActionNumber();

            chooseAction(actionNumber);
            if (actionNumber == QUIT_KEY) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void chooseAction(int actionNumber){
        if (actionNumber == ORDER_KEY) {
            orderProcess();
        }
        if (actionNumber == PAY_KEY) {
            payProcess();
        }
    }

    public static void getTableIndex(int tableNumber) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).isEqaulTableNumber(tableNumber)) {
                nowTableNumber = i;
                break;
            }
        }
    }

    public static void getMenuIndex(int menuCategory) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).isEqaulMenuCategory(menuCategory)) {
                nowMenuCategory = i;
                break;
            }
        }
    }

    public static void orderProcess() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        getTableIndex(tableNumber);
        OutputView.printMenus(menus);
        final int menuCategory = InputView.inputMenuCategory();
        final int menuCount = InputView.inputMenuCount();
        System.out.println(tables.get(nowTableNumber).order(menuCategory, menuCount));
        tables.get(nowTableNumber).printNowOrder();
    }

    public static void payProcess() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        getTableIndex(tableNumber);
        calculateTotalPay();
        payMethod = InputView.inputPayMethod();
        System.out.printf("결제금액 : %f \n", getTotalPay());
        clearPay();
    }

    /* 현재 테이블 안에 존재하는 메뉴 카테고리를 바탕으로
     * 계산하는 caculateTotalPay의 경우는
     * 현재 테이블의 카테고리 리스트에 저장된 메뉴를 순차적으로 구하고
     * 이를 바탕으로 최종 결제금액과 할인에 필요한 치킨의 수량을 구하는 함수이다.
     * calculatePrice 의 경우는 현재 입력된 메뉴의 가격과 테이블리스트에 저장된 menuCount(수량)를
     * 이용하여 계산하는 메서드이다.
     */
    public static void calculateTotalPay() {
        for (int i = 0; i < tables.get(nowTableNumber).menuCategory.size(); i++) {
            getMenuIndex(tables.get(nowTableNumber).menuCategory.get(i));
            totalPay += menus.get(nowMenuCategory).calculatePrice(tables.get(nowTableNumber).menuCount.get(i));
            if (menus.get(nowMenuCategory).getCategory().isChicken()) {
                totalChickenCount += tables.get(nowTableNumber).menuCount.get(i);
            }
        }
    }

    public static void clearPay() {
        totalChickenCount = 0;
        totalPay = 0;
        tables.get(nowTableNumber).clearTable();
        System.out.println("계산이 완료되었습니다.");
    }

    public static double getTotalPay() {
        if (payMethod == CARD_KEY) {
            return totalPay - ((totalChickenCount / CHICKEN_SALE_COUNT) * CHICKEN_SALE);
        }
        return (totalPay - (totalChickenCount / CHICKEN_SALE_COUNT) * CHICKEN_SALE) * CASH_SALE_RATE;
    }


}
