package view;

import domain.MenuRepository;
import domain.TableRepository;
import view.InputView;
import java.util.Objects;
import java.util.Scanner;

public final class ExceptionDetect {
    private static final Scanner scanner = new Scanner(System.in);

    public static final int mainInputException(int action) {
        while (action < 1 || action > 3) {
            System.out.println("1, 2, 3 중 선택해주세요.");
            action = scanner.nextInt();
        }
        return action;
    }

    public static final int tableInputException(int number) {
        while (!TableRepository.isExists(number)) {
            System.out.println("없는 테이블 번호입니다. 테이블 중 다시 선택하세요.");
            number = scanner.nextInt();
        }
        return number;
    }

    public static final int orderMenuException(int number) {
        while (!MenuRepository.isExists(number)) {
            System.out.println("없는 메뉴 번호입니다. 위 목록 중 다시 선택하세요.");
            number = scanner.nextInt();
        }
        return number;
    }

}
