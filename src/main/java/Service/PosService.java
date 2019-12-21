package Service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosService {
    public void run() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        Table selectedTable = selectTable(tables, tableNumber);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        Menu selectedMenu = selectMenu(menus, menuNumber);
        System.out.println("here : " + selectedMenu.toString());

        int menuMount = InputView.inputMenuMount();
        selectedTable.addMenu(selectedMenu, menuMount);
    }

    private Table selectTable(List<Table> tables, int number) {
        return tables.stream()
                .filter(table -> table.isSameTableNumber(number))
                .findFirst()
                .get();
    }

    private Menu selectMenu(List<Menu> menus, int number) {
        return menus.stream()
                .filter(menu -> menu.isSameMenuNumber(number))
                .findFirst()
                .get();
    }
}
