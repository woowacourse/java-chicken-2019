package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository{
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
    
    public static Menu selectMenu(int menuNumber) {         //메뉴번호에 따라서 메뉴를 반환하는 함수
        if (menuNumber == 21) {
            return menus.get(6);
        }
        else if (menuNumber == 22) {
            return menus.get(7);
        }
        else if (menuNumber >= 1 && menuNumber <= 6){            
           return menus.get(menuNumber - 1);
        }
        return null;
    }
}
