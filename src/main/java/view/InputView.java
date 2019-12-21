package view;

import java.util.Scanner;

import domain.food.Menu;
import domain.food.MenuRepository;
import domain.order.Order;
import domain.payment.Payment;
import domain.payment.PaymentFactory;
import domain.food.Table;
import domain.order.TableOrder;
import domain.food.TableRepository;
import initfunction.ChickenFunction;
import initfunction.FunctionFactory;
import util.ValidateUtil;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static ChickenFunction inputFunction() {
		try {
			OutputView.printInitialFunction();
			System.out.println("## 원하는 기능을 선택하세요.");
			return FunctionFactory.getInstance(inputInt());
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return inputFunction();
		}
	}

	public static Table inputTable() {
		try {
			System.out.println("## 테이블을 선택하세요.");
			int data = inputInt();
			return TableRepository.getTableByNumber(data);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return inputTable();
		}
	}

	public static Order inputOrderIn(TableOrder tableOrder) {
		Menu menu = InputView.inputMenu(tableOrder);            // 올바른 코드 아니거나 이미 99개 이상 주문한 경우 빽
		int menuQuantity = InputView.inputMenuQuantity(menu, tableOrder);       //해당 메뉴가 99개 이상 주문 한 경우 빽
		return new Order(menu, menuQuantity);
	}

	private static Menu inputMenu(TableOrder tableOrder) {
		try {
			System.out.println("## 등록할 메뉴를 선택하세요.");
			Menu menu = MenuRepository.getMenuByNumber(inputInt());
			ValidateUtil.validateMenu(menu, tableOrder);
			return menu;
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return inputMenu(tableOrder);
		}
	}

	private static int inputMenuQuantity(Menu menu, TableOrder tableOrder) {
		try {
			System.out.println("## 메뉴의 수량을 입력하세요.");
			int data = inputInt();
			ValidateUtil.validateMenuQuantity(data, menu, tableOrder);
			return data;
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return inputMenuQuantity(menu, tableOrder);
		}
	}

	public static Payment inputPayment() {
		try {
			System.out.println("## 1번 테이블의 결제를 진행합니다.\n## 신용 카드는 1번, 현금은 2번");
			int code = inputInt();
			return PaymentFactory.getInstance(code);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			return inputPayment();
		}
	}

	private static int inputInt() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
			return inputInt();
		}
	}
}
