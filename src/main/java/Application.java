import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());

        InputView.inputMainMenu();
        OutputView.printTables(tables.getTables());

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
