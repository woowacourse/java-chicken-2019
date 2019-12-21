import work.MainCommand;
import work.Order;
import work.Bill;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		while (true) {
			MainCommand mainCommand = new MainCommand();
			mainCommand.getCommand();
			if (mainCommand.isOrder()) {
				new Order().run();
			}
			if (mainCommand.isBill()) {
				new Bill().run();
			}
			if (mainCommand.isExit()) {
				break;
			}
		}
	}
}
