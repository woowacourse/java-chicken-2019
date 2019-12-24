package domain;

import java.util.*;

public class Table {

    private static final String SPACE = " ";
    private static final String DELIMITER_MENU_LINE = "\n";
    private static final int COUNT_NO_MENU = 0;
    private static final int INITIAL_TABLE_PRICE = 0;
    private static final int INITIAL_CHICKEN_COUNT = 0;
    private static final int INITIAL_CHICKEN_DISCOUNT_COUNT = 10;
    private static final int CHICKEN_DISCOUNT = 10000;
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
        for (Menu menu : menuKinds) {
            String menupriceLine = menu.getName() + SPACE + getMenuAmount(menu) + SPACE + menu.getPrice(getMenuAmount(menu));
            sj.add(menupriceLine);
        }
        return sj.toString();
    }

    public int getPrice() {
        int tablePrice = INITIAL_TABLE_PRICE;
        int chickenCount = INITIAL_CHICKEN_COUNT;
        Set<Menu> menuKinds = new HashSet<Menu>(menus);
        for (Menu menu : menuKinds) {
            tablePrice += menu.getPrice(getMenuAmount(menu));
            if (menu.isChicken()) {
                chickenCount += getMenuAmount(menu);
            }
        }
        if (chickenCount >= INITIAL_CHICKEN_DISCOUNT_COUNT) {
            tablePrice = tablePrice - (CHICKEN_DISCOUNT * chickenCount / INITIAL_CHICKEN_DISCOUNT_COUNT);
        }
        return tablePrice;
    }

    public void clear() {
        menus.clear();
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
}
