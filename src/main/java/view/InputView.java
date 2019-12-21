package view;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.Menu;
import domain.MenuRepository;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

public class InputView {
    private static final String NOT_NUMBER_PATTERN = "^[0-9]*$";
    private static final Scanner scanner = new Scanner(System.in);
    
    
    public static int inputOrder() {
    	System.out.println("## 원하는 기능을 선택하세요.");
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
    
    public static int inputRegisterMenu() {
    	System.out.println("## 등록할 메뉴를 선택하세요.");
    	String registeredMenu = scanner.nextLine();
    	if (!Pattern.matches(NOT_NUMBER_PATTERN, registeredMenu)) {
    		System.err.println("주문할 음식의 숫자를 입력해주세요.");
    		return inputRegisterMenu();
    	} else if (!isPresentMenu(Integer.parseInt(registeredMenu))) {
    		System.err.println("존재하지 않는 메뉴입니다. 다시 입력해주세요.");
    		return inputRegisterMenu();
    	}
    	return Integer.parseInt(registeredMenu);
    }
    
    private static boolean isPresentMenu(int registeredMenu) {
    	boolean status = false;
    	for (Menu menu : MenuRepository.menus()) {
    		status = status || menu.isPresentMenu(registeredMenu);
    	}
    	return status;
    }
    
    public static int inputOrderQuantity(List<Table> tables) {
    	System.out.println("## 메뉴의 수량을 입력하세요.");
    	String orderQuantity = scanner.nextLine();
    	if (!Pattern.matches(NOT_NUMBER_PATTERN, orderQuantity)) {
    		System.err.println("주문할 음식의 수량을 숫자로 입력해주세요.");
    		return inputOrderQuantity(tables);
    	} else if (isOverQuantity(Integer.parseInt(orderQuantity), tables)) {
    		System.err.println("해당 음식을 주문할 수 있는 최대 수량(99개)을 넘겼습니다. 다시 입력해주세요");
    		return inputOrderQuantity(tables);
    	}
    	return Integer.parseInt(orderQuantity);
    }
    
    private static boolean isOverQuantity(int orderQuantity, List<Table> tables) {
    	boolean status = false;
    	for (Table table : tables) {
    		status = status || table.isOverQuantity(orderQuantity);
    	}
    	return status;
    }
}
