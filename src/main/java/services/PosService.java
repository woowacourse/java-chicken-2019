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
	TableRepository tableStatus = new TableRepository();


	public Boolean startPos() {
		Integer featureSelect;

		OutputView.printInitialMenu();
		featureSelect = InputView.inputMainFeature();

		return setRepeat(featureSelect);
	}

	private Boolean setRepeat(Integer featureSelect) {
		if (featureSelect == MENU_END) {
			return false;
		}
		return true;
	}
}
