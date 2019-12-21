package view;

import java.util.List;
import java.util.Scanner;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputCommand() {
		System.out.println("## 원하는 기능을 선택하세요.");
		int command = scanner.nextInt();
		if (command != 1 && command != 2 && command != 3) {
			throw new IllegalArgumentException("1,2,3이외의 수는 입력할 수 없습니다");
		}
		return command;
	}

	public static int inputTableNumber(TableRepository tables, boolean isOrder) {
		System.out.println("## 테이블을 선택하세요.");
		int tableNumber = scanner.nextInt();
		if (!tables.getTables().stream().filter(table -> table.getNumber() == tableNumber).findFirst().isPresent()) {
			throw new IllegalArgumentException("입력한 테이블 번호에 해당하는 테이블이 없습니다.");
		}
		if (!isOrder && tables.getByNumber(tableNumber).isEmpty()) {
			throw new IllegalArgumentException("입력한 테이블 번호에 해당하는 테이블에서 주문한 메뉴가 없습니다.");
		}
		return tableNumber;
	}

	public static int inputMenuNumber(MenuRepository menus) {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		int menuNumber = scanner.nextInt();
		if (!menus.getMenus().stream().filter(menu -> menu.getNumber() == menuNumber).findFirst().isPresent()) {
			throw new IllegalArgumentException("입력한 메뉴 번호에 해당하는 메뉴가 없습니다.");
		}
		return menuNumber;
	}

	public static int inputMenuCount() {
		System.out.println("## 메뉴의 수량을 선택하세요.");
		return scanner.nextInt();
	}

	public static int inputPaymentMethod(int tableNum) {
		System.out.println("## " + tableNum + "번 테이블의 결제를 진행합니다.");
		System.out.println("## 신용카드는 1번, 현금은 2번");
		int paymentMethod = scanner.nextInt();
		if (paymentMethod != 1 && paymentMethod != 2) {
			throw new IllegalArgumentException("1과 2만 입력할 수 있습니다.");
		}
		return paymentMethod;
	}
}
