import work.MainCommand;
import work.Order;

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

			}
			if (mainCommand.isExit()) {
				break;
			}
		}
	}
}
