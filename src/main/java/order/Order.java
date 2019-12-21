package order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderMenu;
import domain.OrderTable;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Order {
	private static final int FIRST_MENU = 0;
	private List<OrderMenu> orderMenuList = new ArrayList<>();

	public void orderMenu() {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables);
		final int tableNumber = InputView.inputTableNumber();
		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);

		int menu = InputView.inputOrderMenu();
		Menu selectedMenu = selectMenu(menus, menu);
		int numberOfMenu = InputView.inputNumberOfMenu();
		addToOrderMenuList(selectedMenu, numberOfMenu, tableNumber);
	}

	private Menu selectMenu(List<Menu> menus, int menuNumber) {
		Menu selectedMenu = menus.stream()
			.filter(menu -> menu.containMenuNumber(menuNumber))
			.collect(Collectors.toList())
			.get(FIRST_MENU);
		return selectedMenu;
	}

	private void addToOrderMenuList(Menu selectedMenu, int numberOfMenu, int tableNumber) {
		orderMenuList.add(new OrderMenu(selectedMenu.getNumber(), selectedMenu.getName(), selectedMenu.getCategory(),
			selectedMenu.getPrice(), numberOfMenu, new OrderTable(tableNumber)));
	}

	public List<OrderMenu> getTableToPay(int tableNumber) {
		return orderMenuList.stream()
			.filter(orderMenu -> orderMenu.containTableNumber(tableNumber))
			.collect(Collectors.toList());
	}
}
