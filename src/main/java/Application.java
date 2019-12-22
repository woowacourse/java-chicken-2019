import java.util.List;

import domain.OrderMenu;
import domain.Table;
import domain.TableRepository;
import order.Order;
import pay.Pay;
import view.InputView;
import view.OutputView;

public class Application {
	private static final String NO_ORDER_TABLE = "주문 내역이 없는 테이블 입니다.";
	private static final int MENU_SELECT = 1;
	private static final int PAY = 2;
	private static final int EXIT = 3;

	public static void main(String[] args) {
		Order order = new Order();
		while (true) {
			OutputView.printMainScreen();
			int process = InputView.inputMainProcess();
			if (process == MENU_SELECT) {
				order.orderMenu();
			}
			if (process == PAY) {
				runPaymentProcess(order);
			}
			if (process == EXIT) {
				break;
			}
		}
	}

	private static void runPaymentProcess(Order order) {
		final List<Table> tables = TableRepository.tables();
		List<Integer> occupiedTableNumbers = order.getOccupiedTableNumbers();
		OutputView.printTables(tables, occupiedTableNumbers);
		int tableNumberToPay = InputView.inputTableNumberToPay();
		List<OrderMenu> orderMenuList = order.getTableToPay(tableNumberToPay);
		if (orderMenuList.isEmpty()) {
			System.out.println(NO_ORDER_TABLE);
			return;
		}
		Pay.pay(orderMenuList, tableNumberToPay);
		order.emptyPaidTable(tableNumberToPay);
	}
}
