package flow;

import initfunction.ChickenFunction;
import view.InputView;

public class FlowController {
	private ChickenFunction chickenFunction;

	public void run() {
		chickenFunction = InputView.inputFunction();
		chickenFunction.run();
	}
}
