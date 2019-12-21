package Check;

import domain.Menu;
import domain.Table;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private static final int FUNCTION_MIN = 1;
    private static final int FUNCTION_MAX = 3;
    private ArrayList<Boolean> checkList = new ArrayList<Boolean>();

    /**
     * 에러가 있으면(예외가 발생하면) 있으면 트루 리턴
     */
    public Boolean isInputFunctionError(String number) {
        checkList.add(isInt(number));
        if (checkList.contains(false)) {
            return true;
        }
        checkList.add(isThreeOrLess(number));
        return checkList.contains(false);
    }

    public Boolean isInt(String number) {
        String pattern = "^[0-9]+$";
        if (number.matches(pattern)) {
            return true;
        }
        System.out.println("숫자만 입력하세요.");
        return false;

    }

    public Boolean isThreeOrLess(String number) {
        if (Integer.parseInt(number) <= FUNCTION_MAX && Integer.parseInt(number) >= FUNCTION_MIN) {
            return true;
        }
        System.out.println("1,2,3 중에서만 선택하세요");
        return false;
    }

    public Boolean isInputTableError(String number, final List<Table> tables) {
        checkList.add(isInt(number));
        if (checkList.contains(false)) {
            return true;
        }
        checkList.add(isExistTable(number, tables));
        return checkList.contains(false);
    }

    public Boolean isExistTable(String number, final List<Table> tables) {
        for (Table table : tables) {
            if (number.equals(table.toString())) {
                return true;
            }
        }
        System.out.println("없는 테이블입니다. 다시 입력하세요.");
        return false;
    }

    public Boolean isInputMenuNumberError(String number, final List<Menu> menus) {
        checkList.add(isInt(number));
        if (checkList.contains(false)) {
            return true;
        }
        checkList.add(isExistMenu(number, menus));
        return checkList.contains(false);
    }

    public Boolean isExistMenu(String number, final List<Menu> menus) {
        for (Menu menu : menus) {
            if (Integer.parseInt(number) == menu.getNumber()) {
                return true;
            }
        }
        System.out.println("없는 메뉴입니다. 다시 입력하세요.");
        return false;
    }
}
