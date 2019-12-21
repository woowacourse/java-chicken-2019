package work;

import java.util.InputMismatchException;
import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;

public class TableWork {
	final List<Table> tables;
	final List<Menu> menus;

	public TableWork() {
		tables = TableRepository.tables();
		menus = MenuRepository.menus();
	}
	protected int getTableNumber() {
		int value;
		try{
			value= InputView.inputTableNumber();
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
}
