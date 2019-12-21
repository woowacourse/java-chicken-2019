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
	
	public void turnOn() {
		OneTwoThree oneTwoThree = chooseApplication();
		if (oneTwoThree.isTerminate()) {
			return;
		}
		TableNumber tableNum = getTableNum();
		if (oneTwoThree.isGetOrder()) {
			getOrder(tableNum);
		}
		if (oneTwoThree.isPay()) {
			getPaid(tableNum);
		}
	}
	
	private OneTwoThree chooseApplication() {
		OutputView.showMain();
		OneTwoThree oneTwoThree = new OneTwoThree();
		oneTwoThree.enterOneTwoThree();
		return oneTwoThree;
	}
	
	private TableNumber getTableNum() {
		OutputView.printTables(tables.tables());
		TableNumber tableNum = new TableNumber();
		tableNum.enterNum();
		return tableNum;
	}
	
	private void getOrder(TableNumber tableNum) {
		OutputView.printMenus(MenuRepository.menus());
		tables.enterOrderAt(tableNum);
		turnOn();
	}
	
	private void getPaid(TableNumber tableNum) {
		OutputView.printOrders(tables.tableAt(tableNum).getOrders());
		OutputView.printFinalPrice(tables.tableAt(tableNum).getOrders().calculateFinalPrice(InputView.enterCacheOrCard(tableNum.getValue())));
		turnOn();
	}
}
