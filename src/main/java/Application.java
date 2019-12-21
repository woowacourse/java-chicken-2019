import java.util.List;

import domain.OrderMenu;
import order.Order;
import pay.Pay;
import view.InputView;
import view.OutputView;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		Order order = new Order();

		do {
			OutputView.printMainScreen();
			int process = InputView.inputMainProcess();
			if (process == 1) {
				continue;
			}
			break;
		} while (order.orderMenu());

		int tableNumberToPay = InputView.inputTableNumberToPay();
		List<OrderMenu> orderMenuList = order.getTableToPay(tableNumberToPay);
		Pay.pay(orderMenuList, tableNumberToPay);

	}
}
