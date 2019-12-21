/*
 * @(#)InputView.java       0.1 2019.12.21
 *
 * Copyright (c) 2019 lxxjn0
 */

package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static int inputTableNumber() {
        scanner = new Scanner(System.in);
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputFunctionNumber() {
        scanner = new Scanner(System.in);
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        scanner = new Scanner(System.in);
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuQuantity() {
        scanner = new Scanner(System.in);
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPaymentMethod() {
        scanner = new Scanner(System.in);
        System.out.println("## 신용 카드는 1번, 현금은 2번");
        return scanner.nextInt();
    }
}
