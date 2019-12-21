package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputFuncNumber(){
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumberErr(){
        System.out.println("존재하지 않는 테이블 번호입니다. 다시 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputMenuNumber(){
        System.out.println("등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumberErr(){
        System.out.println("존재하지 않는 메뉴 번호입니다. 다시 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputMenuCount(){
        System.out.println("메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuCountErr(){
        System.out.println("수량이 100을 넘었거나 1보다 작습니다. 다시 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputPaymentNumber(){
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }

    public static int inputPaymentNumberErr(){
        System.out.println("존재하지 않는 결제 수단 번호입니다. 다시 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputPaymentTableNumberErr(){
        System.out.println("결제할 것이 없는 테이블이거나 null 입니다. 다시 입력해주세요");
        return scanner.nextInt();
    }

}
