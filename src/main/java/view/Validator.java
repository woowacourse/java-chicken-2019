package view;

import domain.TableRepository;

public class Validator {
    private static final int MAX_METHOD_NUM = 3;
    
    public static void validateMethodNumber(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("null값은 허용되지 않습니다.");
        }
        if (Integer.parseInt(string) >  MAX_METHOD_NUM) {
            throw new IllegalArgumentException("현재 있는 기능만 입력해주세요.");
        }
    }
    
    public static void validateTableNumber(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("null값은 허용되지 않습니다.");
        }
        if (!TableRepository.isExist(Integer.parseInt(string))) {
            throw new IllegalArgumentException("현재 있는 테이블 숫자만 입력해주세요.");
        }
    }
}
