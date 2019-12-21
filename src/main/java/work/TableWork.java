package work;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;

public class TableWork implements Work{
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
			Validation.checkInList(value,tables.stream().map(table -> table.getNumber()).collect(Collectors.toList()));
		}catch(InputMismatchException e) {
			System.out.println(NUMBER_WARNING);
			InputView.flush();
			return getTableNumber();
		}catch (Exception e){
			System.out.println(e.getMessage());
			return getTableNumber();
		}
		return value;
	}
}
