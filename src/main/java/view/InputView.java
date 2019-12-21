package view;

import java.util.Scanner;

public class InputView {
    private static final int MAX_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final Scanner scanner = new Scanner(System.in);

    public static void inputMainPrint() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
        System.out.println();
    }

    public static int inputFunctionNumber() {
        inputMainPrint();
        System.out.println("## 원하는 기능을 선택하세요.");
        String inputFunctionNumber = scanner.nextLine();
        while (!inputFunctionNumberValidator(inputFunctionNumber)) {
            System.out.println("숫자 1, 2, 3만 가능 합니다.");
            System.out.println("## 원하는 기능을 선택하세요.");
            inputFunctionNumber = scanner.nextLine();
        }

        return Integer.parseInt(inputFunctionNumber);
    }

    private static boolean inputFunctionNumberValidator(String inputFunctionNumber) {
        try {
            int number = Integer.parseInt(inputFunctionNumber);
            return isOneTwoThree(number);
        }
        catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean isOneTwoThree(int number) {
        return number > MIN_NUMBER && number < MAX_NUMBER;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableBillNumber() {
        System.out.println("## 계산할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputCardOrCash() {
        System.out.println("## 신용카드는 1번 ,현금은 2번");
        return scanner.nextInt();
    }
}
