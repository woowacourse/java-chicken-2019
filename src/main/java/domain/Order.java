package domain;

import view.InputView;
import view.OutputView;

public class Order {
    Table table;
    Menu menu;
    int menuCount;

    Order(Table table) {
        this.table = table;
    }

    public static void getOrder(int tableIndex) {
        OutputView.printMenus(MenuRepository.menus());
        String menuNumber;
        do {
            menuNumber = InputView.inputMenu();
        } while (!MenuRepository.validateMenuInput(menuNumber));
    }
}
