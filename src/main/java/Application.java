import controller.ChickenPos;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

import java.util.List;

/**
 * 프로그램을 실행하는 메인부
 *
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-21
 */
public class Application {
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		final List<Menu> menus = MenuRepository.menus();

		ChickenPos chickenPOS = new ChickenPos(tables, menus);
		chickenPOS.run();
	}
}
