import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import order.Order;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {

		OutputView.printMainScreen();
		int process = InputView.inputMainProcess();
		Order order = new Order();

		if (process == 1) {
			order.orderMenu();
		}

	}
}
