import java.util.ArrayList;
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

	public static void main(String[] args) {
		Order order = new Order();
		do {
			OutputView.printMainScreen();
			int process = InputView.inputMainProcess();
			if (process == MENU_SELECT) {
				order.orderMenu();
			}
			if (process == PAY) {
				int tableNumberToPay = InputView.inputTableNumberToPay();
				List<OrderMenu> orderMenuList = order.getTableToPay(tableNumberToPay);
				if (orderMenuList.isEmpty()) {
					System.out.println("주문 내역이 없는 테이블 입니다.");
					continue;
				}
				Pay.pay(orderMenuList, tableNumberToPay);
			}
			if (process == EXIT) {
				break;
			}
		} while (flag);
	}
}
