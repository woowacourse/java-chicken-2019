package Service;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderService {
    public void order(Table table) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int menuNumber = InputView.inputMenuNumber();
        Menu selectedMenu = selectMenu(menus, menuNumber);

        addMenu(table, selectedMenu);
    }

    private Menu selectMenu(List<Menu> menus, int number) {
        return menus.stream()
                .filter(menu -> menu.isSameMenuNumber(number))
                .findFirst()
                .get();
    }

    private void addMenu(Table table, Menu menu) {
        try {
            table.addMenu(menu, InputView.inputMenuAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addMenu(table, menu);
        }

    }
}
