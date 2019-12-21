package view;

import java.util.Scanner;

import domain.FunctionNumber;
import domain.Table;
import domain.TableRepository;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static FunctionNumber inputFunctionNumber() {
		try {
			System.out.println("###원하는 기능을 선택하세요.");
			FunctionNumber functionNumber = new FunctionNumber(scanner.nextLine());
			return functionNumber;
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return inputFunctionNumber();
		}
    }

    public static int inputTableNumber() {
		try {
			OutputView.printTables(TableRepository.tables());
			System.out.println("## 주문할 테이블을 선택하세요.");
			final int tableNumber = Integer.parseInt(scanner.nextLine());;
			Table table = new Table(tableNumber);
			TableRepository.isNotExist(table);
			return tableNumber;
		} catch (Exception e) {
			System.out.println(e);
			return inputTableNumber();
		}
    }
}
