package view;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int inputTableNumber() {
    System.out.println("## 주문할 테이블을 선택하세요.");
    return inputNumber();
  }

  private static int inputNumber() {
    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (
        Exception e) {
      System.out.println("숫자만 입력하세요");
      return inputNumber();
    }
  }

  public static int inputProcessNumber(){
    System.out.println("## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료");
    return inputNumber();
  }

  public static int inputMenuNumber(){
    System.out.println("## 등록할 메뉴를 선택하세요.");
    return inputNumber();
  }

}
