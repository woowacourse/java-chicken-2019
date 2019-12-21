package util;

import static domain.table.order.CountMenu.MAX_MENU_COUNT;

public class ErrorMessage {
    public final static String MENU_COUNT_OVERFLOW = String.format("주문한 메뉴의 개수가 %d개가 넘을 수 없습니다.", MAX_MENU_COUNT);
    public final static String INVALID_MENU_NUMBER = "존재하지 않는 메뉴 번호 입니다.";
    public final static String INVALID_TABLE_NUMBER = "존재하지 않는 테이블 번호 입니다.";

}
