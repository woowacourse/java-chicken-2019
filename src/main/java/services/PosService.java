package services;

import domain.Menu;
import domain.MenuRepository;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class PosService {
	static final int MENU_ADD_ORDER = 1;
	static final int MENU_PAYMENT = 2;
	static final int MENU_END = 3;

	MenuRepository menuBoard = new MenuRepository();
	TableRepository tables = new TableRepository();

	public Boolean startPos() {
		Integer featureSelect;

		OutputView.printInitialMenu();
		featureSelect = InputView.inputMainFeature();

		if (featureSelect == MENU_ADD_ORDER) {
			addOrder();
		} else if (featureSelect == MENU_PAYMENT) {

		}

		return setRepeat(featureSelect);
	}

	private void addOrder() {
		Integer tableNumber = InputView.inputTableNumber();
		if (!tableNumber.equals(0)) {
			System.out.println(tableNumber);
			Integer menuNumber = InputView.inputMenuNumber();

			tables.addOrder(tableNumber
					, menuBoard.getMenuByMenuNumber(menuNumber));
		}
	}

	private Boolean setRepeat(Integer featureSelect) {
		if (featureSelect == MENU_END) {
			return false;
		}
		return true;
	}
}
