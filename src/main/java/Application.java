import java.util.ArrayList;
import java.util.List;

import domain.OrderMenu;
import order.Order;
import pay.Pay;
import view.InputView;
import view.OutputView;

public class Application {
	// TODO 구현 진행
	private static boolean flag = true;

	public static void main(String[] args) {
		Order order = new Order();

		do {
			OutputView.printMainScreen();
			int process = InputView.inputMainProcess();
			if (process == 1) {
				order.orderMenu();
			}

			if (process == 2) {
				int tableNumberToPay = InputView.inputTableNumberToPay();
				List<OrderMenu> orderMenuList = order.getTableToPay(tableNumberToPay);
				if (orderMenuList.isEmpty()) {
					System.out.println("주문 내역이 없는 테이블 입니다.");
					continue;
				}
				Pay.pay(orderMenuList, tableNumberToPay);
			}

			if (process == 3) {
				break;
			}

		} while (flag);

	}
}
