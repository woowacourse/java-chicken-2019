package view;

import domain.TableRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return TableRepository.checkExistTable(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputTableNumber();
        }
    }
}