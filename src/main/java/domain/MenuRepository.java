/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * MenuRepository.java
 * 메뉴 데이터를 조회하는 DB역할을 하는 객체
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

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

    public static boolean hasMenuNumber(String inputMenuNumber) {
        int menuNumber = Integer.parseInt(inputMenuNumber);
        for (Menu menu : menus()) {
            if (menu.getNumber() == menuNumber) {
                return true;
            }
        }
        return false;
    }

    public static Menu getMenuByNumber(int number) {
        for (Menu menu : menus) {
            if (menu.getNumber() == number) {
                return menu;
            }
        }
        return null;
    }
}
