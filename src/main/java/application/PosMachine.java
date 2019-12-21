package application;

import java.util.List;

import domain.Table;
import domain.TableRepository;
import view.OutputView;
import domain.MenuRepository;
import domain.TableNumber;

public class PosMachine {
	private TableRepository tables = new TableRepository();
	
	public PosMachine() {};
	
	public void oneCycle () {
		OutputView.showMain();
		OneTwoThree oneTwoThree = new OneTwoThree();
		oneTwoThree.enterOneTwoThree();
		if (oneTwoThree.isTerminate()) {
			return;
		}
		OutputView.printTables(tables.tables());
		TableNumber tableNum = new TableNumber();
		tableNum.enterNum();
		tables.enterOrderAt(tableNum);
		tables.showTableStates();
		OutputView.printTables(tables.tables());
	}
}
