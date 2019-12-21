import java.util.List;

import domain.OrderMenu;
import order.Order;
import pay.Pay;
import view.InputView;
import view.OutputView;

public class Application {
	private static boolean flag = true;
	private static int MENU_SELECT = 1;
	private static int PAY = 2;
	private static int EXIT = 3;
	private static final String NO_ORDER_TABLE = "주문 내역이 없는 테이블 입니다.";

	public static void main(String[] args) {
		Application application = new Application();
		Order order = new Order();
		do {
			OutputView.printMainScreen();
			int process = InputView.inputMainProcess();
			if (process == MENU_SELECT) {
				order.orderMenu();
			}
			if (process == PAY) {
				application.runPaymentProcess(order);
			}
			if (process == EXIT) {
				break;
			}
		} while (flag);
	}

	private void runPaymentProcess(Order order) {
		int tableNumberToPay = InputView.inputTableNumberToPay();
		List<OrderMenu> orderMenuList = order.getTableToPay(tableNumberToPay);
		if (orderMenuList.isEmpty()) {
			System.out.println(NO_ORDER_TABLE);
			return;
		}
		Pay.pay(orderMenuList, tableNumberToPay);
	}
}
