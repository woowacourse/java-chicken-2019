package application;

import java.util.List;

import domain.Table;
import domain.TableRepository;
import view.InputView;
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
		if (oneTwoThree.isGetOrder()) {
			OutputView.printMenus(MenuRepository.menus());
			tables.enterOrderAt(tableNum);
			oneCycle();
		}
		if (oneTwoThree.isPay()) {
			OutputView.printOrders(tables.tableAt(tableNum).getOrders());
			OutputView.printFinalPrice(tables.tableAt(tableNum).getOrders().calculateFinalPrice(InputView.enterCacheOrCard(tableNum.getValue())));
			oneCycle();
		}
	}
}
