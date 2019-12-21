import order.Order;
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

	}
}
