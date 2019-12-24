package domain;

import java.util.*;

public class Table {
    public static final String MESSAGE_NO_MENU = "테이블에 결재할 메뉴가 없습니다";
    public static final String SPACE = " ";
    public static final String DELIMITER_MENU_LINE = "\n";
    public static final int COUNT_NO_MENU = 0;
    private final int number;
    private List<Menu> menus;

    public Table(final int number) {
        this.number = number;
        this.menus = new ArrayList<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isEqualNumber(int inputNumber) {
        return this.number == inputNumber;
    }

    public boolean hasMenu() {
        return menus.size() > COUNT_NO_MENU;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public String getMenus() {
        StringJoiner sj = new StringJoiner(DELIMITER_MENU_LINE);
        Set<Menu> menuKinds = new HashSet<Menu>(menus);
        if (menus.size() == COUNT_NO_MENU) {
            return MESSAGE_NO_MENU;
        }
        for (Menu menu : menuKinds) {
            String menupriceLine = menu.getName() + SPACE + getMenuAmount(menu) + SPACE + menu.getPrice(getMenuAmount(menu));
            sj.add(menupriceLine);
        }
        return sj.toString();
    }
    private int getMenuAmount(Menu targetMenu) {
        int menuAmount = COUNT_NO_MENU;
        for (Menu menu : menus) {
            if (menu == targetMenu) {
                menuAmount++;
            }
        }
        return menuAmount;
    }

    public int getPrice() {
        int tablePrice = 0;
        Set<Menu> menuKinds = new HashSet<Menu>(menus);
        for (Menu menu : menuKinds) {
            tablePrice += menu.getPrice(getMenuAmount(menu));
        }
        return tablePrice;
    }
}
