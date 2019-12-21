package com.github.callmewaggs.chickenpos.view;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static int inputTableNumber() {
    System.out.println("## 주문할 테이블을 선택하세요.");
    return scanner.nextInt();
  }
  public static int inputMenuNumber() {
    System.out.println("## 등록할 메뉴를 선택하세요.");
    return scanner.nextInt();
  }
}
