import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        order(tables, menus);
    }

    private static void order(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int menuHowMany = InputView.inputHowManyMenu();
        tables.get(tableNumber).getOrder(menus.get(menuNumber), menuHowMany);
    }

}
