package domain;

import sun.jvm.hotspot.runtime.StaticBaseConstructor;
import view.InputView;
import view.OutputView;

public class Order {
    Table table;
    Menu menu;
    int menuCount;

    public Order(Table table) {
        if (table == null)
            throw new IllegalArgumentException("테이블이 잘못되었습니다.");
        this.table = table;
    }

    public void getOrder() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = getMenuNumber();
        int menuCount = getMenuCount();
        addOrder(menuNumber, menuCount);
    }

    int getMenuNumber() {
        String menuNumber;
        do {
            menuNumber = InputView.inputMenu();
        } while (!MenuRepository.validateMenuInput(menuNumber));
        return Integer.parseInt(menuNumber);
    }

    int getMenuCount() {
        String menuCount;
        do {
            menuCount = InputView.inputMenuCount();
        } while (!validateMenuCount(menuCount));
        return Integer.parseInt(menuCount);
    }

    boolean validateMenuCount(String input) {
        if (!MenuRepository.validateMenuCountInput(input))
            return false;
        int menuCount = Integer.parseInt(input);

        if (table.getTableMenuCount() + menuCount > MenuRepository.get_MAX_MENU_COUNT()){
            System.out.println("주문 가능한 수량을 초과했습니다.");
            return false;
        }
        return true;
    }

    void addOrder(int menuNumber, int menuCount) {
        Menu menu = MenuRepository.getMenu(menuNumber);
        if (menu == null) {
            System.out.println("메뉴가 잘못되었습니다.");
            return;
        }

        for (int i = 0; i < menuCount; i++)
            table.addMenu(menu);
        System.out.println("주문이 완료되었습니다.\n");
    }
}
