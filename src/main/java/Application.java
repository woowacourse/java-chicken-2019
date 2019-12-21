import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		OutputView.printTables(tables); // 테이블 목록 출력

		final int tableNumber = InputView.inputTableNumber();

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);
	}

	private static void findTable(List<Table> tables) {
		final int tableNumber = InputView.inputTableNumber();
		for (Table eachTable : tables) {
			if (eachTable.isSame(tableNumber)) {
				// 현재 테이블에 주문받아라
				return; // 찾으면 끝내야 함
			}
			System.out.println("찾는 테이블이 없다.");
			// 재귀
		}
	}
}
