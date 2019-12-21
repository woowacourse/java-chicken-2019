package view;

import domain.MenuRepository;
import domain.TableRepository;

public class Validator {
    private static final int MAX_METHOD_NUM = 3;
    
    public static void validateNull(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("null값은 허용되지 않습니다.");
        }
    }
    
    public static void validateMethodNumber(String string) {
        validateNull(string);
        if (Integer.parseInt(string) >  MAX_METHOD_NUM) {
            throw new IllegalArgumentException("현재 있는 기능만 입력해주세요.");
        }
    }
    
    public static void validateTableNumber(String string) {
        validateNull(string);
        if (!TableRepository.isExist(Integer.parseInt(string))) {
            throw new IllegalArgumentException("현재 있는 테이블 숫자만 입력해주세요.");
        }
    }
    
    public static void validateMenuNumber(String string) {
        validateNull(string);
        if (!MenuRepository.isExist(Integer.parseInt(string))) {
            throw new IllegalArgumentException("현재 있는 메뉴 숫자만 입력해주세요.");
        }
    }
}
