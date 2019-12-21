package domain;

import java.util.*;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

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

    public static List<Integer> menuNumbers() {
        List<Integer> menusNumber = new ArrayList<Integer>();
        for (Menu menu : menus) {
            menusNumber.add(menu.getNumber());
        }
        return menusNumber;
    }

    public static Menu selectMenu(int menuNumber) {
        Set<Menu> selectMenu = new HashSet<Menu>();
        for (Menu menu : menus) {
            selectMenu.add(compareMenu(menu, menuNumber));
        }
        selectMenu.remove(null);
        return selectMenu.iterator().next();
    }

    private static Menu compareMenu(Menu menu, int menuNumber) {
        if (menu.getNumber() == menuNumber) {
            return menu;
        }
        return null;
    }
}
