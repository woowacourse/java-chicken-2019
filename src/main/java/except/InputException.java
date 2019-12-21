package except;

import domain.Menu;
import domain.Table;

import java.util.List;

public class InputException {

    private static final int HUNDRED = 100;

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            System.out.println("숫자를 입력해주세요!");
            return false;
        }
    }

    public static boolean tableNumberException(List<Table> tables, int tableNumber) {
        if (tables.stream().anyMatch(x -> x.getNumber() == tableNumber)) {
            return false;
        }
        System.out.println("올바른 테이블을 입력해주세요!");
        return true;
    }

    public static boolean menuNumberException(List<Menu> menus, int menuNumber) {
        if (menus.stream().anyMatch(x -> x.isForeignKey(menuNumber))) {
            return false;
        }
        System.out.println("올바른 메뉴 번호를 입력해주세요.");
        return true;
    }

    public static boolean isRange(int count, int length) {
        if (count >= 0 && count < length)
            return true;
        System.out.println("정확한 범위를 입력해주세요!");
        return false;
    }

    public static void notTableError() {
        System.out.println("테이블이 비어있습니다.");
    }

    public static boolean overCheck(int number) {
        if (number >= HUNDRED) {
            System.out.println("메뉴 초과로 주문이 취소되었습니다.");
            return true;
        }
        return false;
    }
}
