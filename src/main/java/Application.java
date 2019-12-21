import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import utils.SelectionHandeler;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        OutputView.printMainMenu();
        final int menuNumber = SelectionHandeler.selectMenu();
        if (menuNumber == 1) {
            OutputView.printTables(tables);
            final int tableNumber = SelectionHandeler.selectTable();
        }
        if(menuNumber == 2) {
            OutputView.printMenus(menus);
        }
    }
}
