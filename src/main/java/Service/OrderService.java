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

        int menuAmount = InputView.inputMenuAmount();
        table.addMenu(selectedMenu, menuAmount);
    }

    private Menu selectMenu(List<Menu> menus, int number) {
        return menus.stream()
                .filter(menu -> menu.isSameMenuNumber(number))
                .findFirst()
                .get();
    }
}
