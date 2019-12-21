package application;

import domain.TableRepository;
import view.OutputView;
import domain.MenuRepository;

public class PosMachine {
	public PosMachine() {};
	
	public void oneCycle () {
		OutputView.showMain();
		OneTwoThree oneTwoThree = new OneTwoThree();
		oneTwoThree.enterOneTwoThree();
		if (oneTwoThree.isTerminate()) {
			return;
		}
		OutputView.printTables(TableRepository.tables());
	}
}
