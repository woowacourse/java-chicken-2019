package view;

import domain.Table;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputProgramCategory(){
        System.out.println("##원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenu(){
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuCount(){
        System.out.println("## 메뉴의 수량을 입력하세요");
        return scanner.nextLine();
    }

    public static String inputPaymentMethod(Table table){
        System.out.println("## "+table.getNumber()+"번 테이블의 결제를 진행합니다.");
        System.out.println("## 신용카드는1번,현금은2번");
        return scanner.nextLine();
    }

    public static String inputFinishSign() {
        System.out.println("정말 종료하시겠습니까? (종료하시려면 y, 아니면 n를 입력해주세요.");
        return scanner.nextLine();
    }
}
