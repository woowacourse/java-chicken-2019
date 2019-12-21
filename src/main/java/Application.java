import domain.Menu;
import domain.MenuRepository;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());

        InputView.inputMainMenu();
        OutputView.printTables(tables.getTables());

        if (tables.isTableExist(InputView.inputTableNumber())) {
            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
        }


    }
}
