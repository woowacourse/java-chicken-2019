package domain;

import sun.jvmstat.monitor.event.VmListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();
    private static final int MAX_MENU_COUNT = 99;

    static {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.add(new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.add(new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.add(new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.add(new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.add(new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static boolean validateMenuInput(String input) {
        int menuNumber = Validate.validateNumber(input);
        return validateMenuNumber(menuNumber);
    }

    public static boolean validateMenuNumber(int menuNumber) {
        for (int i = 0; i < menus().size(); i++) {
            if (menus.get(i).getNumber() == menuNumber)
                return true;
        }
        System.out.println("메뉴 번호가 잘못되었습니다.\n");
        return false;
    }

    public static boolean validateMenuCountInput(String menuCountInput){
        int menuCount = Validate.validateNumber(menuCountInput);
        return validateMenuCountNumber(menuCount);
    }

    public static boolean validateMenuCountNumber(int menuCount){
        if (menuCount <= 0) {
            System.out.println("1개 이상 주문해야 합니다.");
            return false;
        }
        return true;
    }

    public static int get_MAX_MENU_COUNT(){
        return MAX_MENU_COUNT;
    }
}
