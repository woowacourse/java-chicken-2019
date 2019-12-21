package application;

import domain.TableRepository;
import view.OutputView;
import domain.MenuRepository;

public class PosMachine {
	private TableRepository tables;
	private MenuRepository menues;
	
	public PosMachine() {};
	
	public void oneCycle () {
		OutputView.showMain();
		OneTwoThree.askWhichApplication();
	}
}
