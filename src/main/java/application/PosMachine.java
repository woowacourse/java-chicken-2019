package application;

import domain.TableRepository;
import domain.MenuRepository;

public class PosMachine {
	private TableRepository tables;
	private MenuRepository menues;
	
	public PosMachine() {};
	
	public void play () {
		OneTwoThree.askWhichApplication();
	}
}
