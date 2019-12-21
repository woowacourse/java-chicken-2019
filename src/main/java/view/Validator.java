package view;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class Validator {
    private static final int MIN_NUM = 0;
    private static final int MAX_METHOD_NUM = 3;
    private static final int MAX_PAYMENT_NUM = 2;
    private static final int MAX_MENU_COUNT = 99;
    
    public static void validateNull(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("null값은 허용되지 않습니다.");
        }
    }
    
    public static void validateMethodNumber(String string) {
        validateNull(string);
        if (Integer.parseInt(string) >  MAX_METHOD_NUM
                || Integer.parseInt(string) <=  MIN_NUM) {
            throw new IllegalArgumentException("현재 있는 기능만 입력해주세요.");
        }
    }
    
    public static void validateTableNumber(String string) {
        validateNull(string);
        if (!TableRepository.isExist(Integer.parseInt(string))) {
            throw new IllegalArgumentException("현재 있는 테이블 숫자만 입력해주세요.");
        }
    }
    
    public static void validateMenuCount(String string) {
        validateNull(string);
        if (Integer.parseInt(string) <=  MIN_NUM) {
            throw new IllegalArgumentException("1개 이상의 값을 입력해주세요.");
        }
    }
    
    public static void validateMenuNumber(String string) {
        validateNull(string);
        if (!MenuRepository.isExist(Integer.parseInt(string))) {
            throw new IllegalArgumentException("현재 있는 메뉴 숫자만 입력해주세요.");
        }
    }
    
    public static void validatePaymentNumber(String string) {
        validateNull(string);
        if (Integer.parseInt(string) > MAX_PAYMENT_NUM
                || Integer.parseInt(string) <=  MIN_NUM) {
            throw new IllegalArgumentException("신용카드(1), 현금(2) 중 하나만 선택하세요.");
        }
    }
    
    public static void validateNullMenus(Table table) {
        if (table.isEmptyMenus()) {
            throw new IllegalArgumentException("테이블에 결제할 목록이 없습니다.");
        }
    }
    
    public static void validateMenuMaxCount(int count) {
        if (count > MAX_MENU_COUNT) {
            throw new IllegalArgumentException("메뉴 총 주문 한도를 초과하셨습니다.");
        }
    }
}
