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
		final List<Menu> menus = MenuRepository.menus();
		
		while (true) {
			OutputView.printMainView(); // 메인화면 출력
			int userInput = InputView.validMainViewInput(); // 사용자 입력을 받아서
			if (userInput == 1) { // 주문등록
				OutputView.printTables(tables); // 테이블 목록 출력
				Table targetTable = findTable(tables);
				OutputView.printMenus(menus); // 메뉴 목록 출력
				Menu targetMenu = findMenu(menus);
				int quantity = InputView.inputQuantity();
				targetTable.addMenu(targetMenu, quantity);
			}
			if (userInput == 2) { // 결제
				
			}
			if (userInput == 3) { // 프로그램 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
		}
	}

	private static Table findTable(List<Table> tables) {
		final int tableNumber = InputView.inputTableNumber();
		for (Table eachTable : tables) {
			if (eachTable.isSame(tableNumber)) {
				// 현재 테이블에 주문받아라
				return eachTable; // 찾으면 끝내야 함
			}
//			System.out.println("찾는 테이블이 없다.");
			// 재귀
		}
		return null;
	}
	
	private static Menu findMenu(List<Menu> menus) {
		int menuNumber = InputView.inputMenu();
		for (Menu eachMenu: menus) {
			if (eachMenu.isSame(menuNumber)) {
				return eachMenu;
			}
		}
		return null;
	}
}
