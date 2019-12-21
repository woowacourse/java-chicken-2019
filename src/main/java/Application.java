import controller.ChickenPos;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		final List<Menu> menus = MenuRepository.menus();

		ChickenPos chickenPOS = new ChickenPos(tables, menus);
		chickenPOS.run();
	}
}
