package view;

import java.util.Scanner;

import domain.FunctionNumber;
import domain.Menu;
import domain.MenuCount;
import domain.MenuRepository;
import domain.PaymentOption;
import domain.Table;
import domain.TableRepository;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static FunctionNumber inputFunctionNumber() {
		try {
			System.out.println("###원하는 기능을 선택하세요.");
			FunctionNumber functionNumber = new FunctionNumber(Integer.parseInt(scanner.nextLine()));
			System.out.println();
			return functionNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return inputFunctionNumber();
		}
    }

    public static Table inputTableNumber() {
		try {
			OutputView.printTables(TableRepository.tables());
			System.out.println("\n## 테이블을 선택하세요.");
			return TableRepository.isExist(new Table(Integer.parseInt(scanner.nextLine())));
		} catch (Exception e) {
			System.out.println(e);
			return inputTableNumber();
		}
    }
    
    public static Menu inputMenuNumber() {
 		try {
 			System.out.println("## 등록할 메뉴를 선택하세요.");
 			return MenuRepository.isExist(Integer.parseInt(scanner.nextLine()));
 		} catch (Exception e) {
 			System.out.println(e);
 			return inputMenuNumber();
 		}
     }
    
    public static MenuCount inputMenuCount() {
    	try {
 			System.out.println("\n## 메뉴의 수량을 입력하세요.");
 			return new MenuCount(Integer.parseInt(scanner.nextLine()));
 		} catch (Exception e) {
 			System.out.println(e);
 			return inputMenuCount();
 		}
    }
    
    public static PaymentOption inputPaymentOption() {
    	try {
 			System.out.println("## 신용카드는 1번, 현금은 2번");
 			return new PaymentOption(Integer.parseInt(scanner.nextLine()));
 		} catch (Exception e) {
 			System.out.println(e);
 			return inputPaymentOption();
 		}
    }
}
