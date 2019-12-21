package view;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;

import java.util.List;

public class Message {
    public static final String MAIN_SCREEN = "## 메인화먄";
    public static final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String TABLE_LIST = "## 테이블 목록";
    public static final String INPUT_TABLE_NUMBER = "## 테이블을 선택하세요.";
    public static final String INPUT_REGISTER_MENU = "## 등록할 메뉴를 선택하세요.";
    public static final String INPUT_MENU_AMOUNT = "## 메뉴 수량을 입력하세요.";
    public static final String ORDERED_LIST = "## 주문 내역";
    private static final String CONTINUE_TABLE_PAYMENT = "## %s번 테이블 결제를 진행합니다.";
    public static final String CREDIT_CARD_OR_CASH = "## 신용카드는 1번, 현금은 2번";
    public static final String FINAL_COST = "## 최종 결제할 금액";
    public static final String WON = "원";
    public static final String NEW_LINE = "\n";

    public static final void printMenuList() {
        List<Menu> menus = MenuRepository.menus();
        final int size = menus.size();
        for (int index = 0; index < size; index++) {
            System.out.println(menus.get(index).toString());
        }
    }

    public static final void printContinueTablePayment(Table table) {
        System.out.printf(CONTINUE_TABLE_PAYMENT, table.toString());
    }
}
