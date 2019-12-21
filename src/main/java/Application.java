import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int EVERY_TEN = 10;
	private static final int DISCOUNT_WON = 10000;
	private static final double DISCOUNT_RATIO = 0.05;
	// TODO 구현 진행
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		final List<Menu> menus = MenuRepository.menus();
		
		while (true) {
			OutputView.printMainView(); // 메인화면 출력
			int userInput = InputView.validMainViewInput(); // 사용자 입력을 받아서
			if (userInput == ONE) { // 주문등록
				OutputView.printTables(tables); // 테이블 목록 출력
				Table targetTable = findTable(tables); // 선택된 테이블 저장
				OutputView.printMenus(menus); // 메뉴 목록 출력
				Menu targetMenu = findMenu(menus); // 선택된 메뉴 저장
				int quantity = InputView.inputQuantity(); // 선택된 수량 저장
				targetTable.addMenu(targetMenu, quantity); // 선택된 테이블에 메뉴와 수량 저장
			}
			if (userInput == TWO) { // 결제
				OutputView.printTables(tables); // 테이블 목록 출력
				Table targetTable = findTable(tables); // 선택된 테이블 저장
				// 주문내역 출력해야함
				// n번 테이블의 결제를 진행함니다 출력해야함
				double totalPrice = targetTable.getTotalPrice(); // 선택된 테이블의 결제금액 계산
				totalPrice -= (targetTable.numberOfChickenQty() % EVERY_TEN) * DISCOUNT_WON; // 치킨수량합이 10개이상일때마다 할인
				int paymentMethod = InputView.choosePaymentMethod();
				if (paymentMethod == 2) {
					totalPrice = totalPrice * (1 - DISCOUNT_RATIO); // 현금일 경우, 5%할인
				}
				OutputView.printFinalPrice(totalPrice); // 최종결제금액 출력
			}
			if (userInput == THREE) { // 프로그램 종료
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
