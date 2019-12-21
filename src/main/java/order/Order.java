package order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderMenu;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Order {
	List<OrderMenu> orderMenuList = new ArrayList<>();

	public boolean orderMenu() {

		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);

		int menu = InputView.inputOrderMenu();
		Menu selectedMenu = selectMenu(menus, menu);
		System.out.println(selectedMenu);
		InputView.inputNumberOfMenu();

		// orderMenuList.add(new OrderMenu())

		return true;
	}

	private Menu selectMenu(List<Menu> menus, int menuNumber) {
		Menu selectedMenu = menus.stream()
			.filter(menu -> menu.containMenuNumber(menuNumber))
			.collect(Collectors.toList())
			.get(0);
		return selectedMenu;
	}
}
