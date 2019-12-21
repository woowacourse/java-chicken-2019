import java.util.List;

import domain.MenuRepository;
import domain.Order;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class GetOrder {
	final List<Table> tables = TableRepository.tables();
	
	public void run() {
		Table table = InputView.inputTableNumber();
		OutputView.printMenus(MenuRepository.menus());
		Order order = new Order(InputView.inputMenuNumber(), InputView.inputMenuCount());
		
		table.getOrders().addOrder(order);
	}
}
