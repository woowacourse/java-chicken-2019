package view;

import java.util.List;
import java.util.Scanner;

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
        System.out.println("## 주문할 테이블을 선택하세요.");
		return ExceptionHandler.inputSelectTableHandler(tables);
	}


}
