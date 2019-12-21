package view;

import domain.MainMenuRepository;
import domain.Tables;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(Tables tables) {
        int tableNumber = 0;
        System.out.println("## 주문할 테이블을 선택하세요.");
        do {
            tableNumber = scanner.nextInt();
        } while (!tables.hasTableNumber(tableNumber));

        return tableNumber;
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
