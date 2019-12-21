package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputActionNumber(){
        System.out.println("## 원하는 기능을 선택하세요.");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시입력해주세요");
        }
        return scanner.nextInt();
    }
    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시입력해주세요");
        }
        return scanner.nextInt();
    }

    public static int inputMenuCategory() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시입력해주세요");
        }
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 선택하세요.");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시입력해주세요");
        }
        return scanner.nextInt();
    }

    public static int inputPayMethod() {
        System.out.println("## 결제방식을 선택하세요.");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("다시입력해주세요");
        }
        return scanner.nextInt();
    }
}
