package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderController {
    private Tables tables;

    public OrderController(Tables tables) {
        this.tables = tables;
    }

    public void run() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();

    }

}
