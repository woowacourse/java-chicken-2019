package view;

import domain.MenuRepository;
import domain.TableRepository;
import java.util.Scanner;

/**
 * 예외 처리를 담당하는 클래스
 */
public final class ExceptionDetect {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 가장 처음 주문/결제/종료 여부 입력에 대한 예외처리
     */
    public static final int mainInputException(int action) {
        while (action < 1 || action > 3) {
            System.out.println("1, 2, 3 중 선택해주세요.");
            action = scanner.nextInt();
        }
        return action;
    }

    public static final int tableInputException(int number, int action) {
        while (!TableRepository.isExists(number)) {
            System.out.println("없는 테이블 번호입니다. 위의 테이블 중 다시 선택하세요.");
            number = scanner.nextInt();
        }
        return number;
    }

    public static final int orderMenuException(int number) {
        while (!MenuRepository.isExists(number)) {
            System.out.println("없는 메뉴 번호입니다. 위의 메뉴 목록 중 다시 선택하세요.");
            number = scanner.nextInt();
        }
        return number;
    }

    public static final boolean orderCountException(int number) {
        while (number < 0) {
            System.out.println("1개 이상 주문 가능합니다. 다시 선택해주세요.");
            return false;
        }
        while (number > 99) {
            System.out.println("99개 이상 주문 불가합니다. 다시 선택해주세요.");
            return false;
        }
        return true;
    }

}
