package view;

import domain.MainMenuRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMainMenuNumber() {
        int mainMenuNumber = 0;
        System.out.println("## 원하는 기능을 선택하세요");
        do {
            mainMenuNumber = scanner.nextInt();
        } while (!MainMenuRepository.isRightInput(mainMenuNumber));

        return mainMenuNumber;
    }

}
