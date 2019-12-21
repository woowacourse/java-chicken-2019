package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static Menu getMenuByNum(int num) {
        if (num < 1 || num > 22) {
            throw new IllegalArgumentException("메뉴는 1,2,3,4,5,6,21,22번 이어야합니다.");
        }
        if (num > 6 && num < 21) {
            throw new IllegalArgumentException("메뉴는 1,2,3,4,5,6,21,22번 이어야합니다.");
        }

        if (num < 7) {
            return menus.get(num - 1);
        }
        return menus.get(num - 15);
    }
}
