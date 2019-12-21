package view;

import domain.Table;
import domain.TableRepository;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Objects;

public class InputView {
    private static final String NOT_NUMBER_PATTERN = "^[0-9]*$";
    private static final Scanner scanner = new Scanner(System.in);
    
    
    public static int inputOrder() {
    	String order = scanner.nextLine();
    	if (!Pattern.matches(NOT_NUMBER_PATTERN, order)) {
    		System.err.println("명령을 숫자로만 입력해주세요.");
    		return inputOrder();
    	} else if (!isPresentOrder(order)) {
    		System.err.println("존재하지 않는 명령입니다. 1,2,3 중 하나를 선택해주세요.");
    		return inputOrder();
    	} else if (Objects.isNull(order)) {
    		System.err.println("명령을 입력하지 않았습니다. 명령을 입력해주세요.");
    		return inputOrder();
    	}
    	return Integer.parseInt(order);
    }
    
    private static boolean isPresentOrder(String order) {
    	if (Integer.parseInt(order) == 1 || Integer.parseInt(order) == 2 || Integer.parseInt(order) == 3) {
    		return true;
    	}
    	return false;
    }
    
    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
    	String tableNum = scanner.nextLine();
        if (!Pattern.matches(NOT_NUMBER_PATTERN, tableNum)) {
    		System.err.println("테이블 번호를 숫자로만 입력해주세요.");
    		return inputTableNumber();
    	} else if (!isPresentTable(Integer.parseInt(tableNum))) {
    		System.err.println("존재하지 않는 테이블 번호입니다. 다시 입력해주세요.");
    		return inputTableNumber();
    	}
        return Integer.parseInt(tableNum);
    }
    
    private static boolean isPresentTable(int tableNum) {
    	boolean status = false;
    	for (Table table : TableRepository.tables()) {
    		status = status || table.isPresentTable(tableNum);
    	}
    	return status;
    }
}
