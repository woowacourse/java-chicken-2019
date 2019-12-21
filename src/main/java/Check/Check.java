package Check;

import java.util.ArrayList;

public class Check {
    private static final int FUNCTION_MIN = 1;
    private static final int FUNCTION_MAX = 3;
    private ArrayList<Boolean> checkList = new ArrayList<Boolean>();

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
}
