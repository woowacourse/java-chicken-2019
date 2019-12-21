package work;

import java.util.InputMismatchException;
import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Order {
	final List<Table> tables;
	int tableNumber;
	final List<Menu> menus;

	public Order() {
		tables = TableRepository.tables();
		menus = MenuRepository.menus();
		OutputView.printTables(tables);
	}

	public void run() {
		tableNumber =getTableNumber();
		OutputView.printMenus(menus);
		int menuChoice= getMenuChoice();
	}

	private int getTableNumber() {
		int value;
		try{
			value=InputView.inputTableNumber();
			Validation.checkPositiveRange(value,tables.size());
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getTableNumber();
		}catch (Exception e){
			System.out.println(e.getMessage());
			return getTableNumber();
		}
		return value;
	}

	private int getMenuChoice(){
		int value;
		try{
			value=InputView.inputMenuChoice();
			Validation.checkPositiveRange(value,menus.size());
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력해주세요.");
			InputView.flush();
			return getTableNumber();
		}catch (Exception e){
			System.out.println(e.getMessage());
			return getTableNumber();
		}
		return value;
	}
}
