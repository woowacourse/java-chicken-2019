package view;

import java.util.List;
import java.util.Scanner;

import domain.Menu;
import domain.Table;
import util.ExceptionHandler;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputSelectWork() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
		return ExceptionHandler.inputSelectWorkHandler();
	}

	public static int inputSelectTable(List<Table> tables) {
		System.out.println("\n## 주문할 테이블을 선택하세요.");
		return ExceptionHandler.inputSelectTableHandler(tables);
	}

	public static int inputSelectMenu(List<Menu> menus) {
		System.out.println("\n## 등록할 메뉴를 선택하세요.");
		return ExceptionHandler.inputSelectMenuHandler(menus);
	}

	public static int inputSelectMenuCount(Table table) {
		System.out.println("\n## 메뉴의 수량을 입력하세요.");
		return ExceptionHandler.inputSelectMenuCountHandler(table);
	}

	public static int inputSelectHowToPay(int nowTable) {
		System.out.println("\n## " + nowTable + "번 테이블의 결제를 진행합니다.");
		System.out.println("\n## 신용 카드는 1번, 현금은 2번");
		return ExceptionHandler.inputSelectHowToPayHandler();
	}

}
