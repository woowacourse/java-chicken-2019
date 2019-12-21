package view;

import domain.MenuRepository;
import domain.reserved.OrderStatement;
import domain.reserved.OrderedMenu;
import view.dto.FeatureType;
import view.dto.PaymentType;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static FeatureType inputSelectFeature() {
        try {
            System.out.println("## 메인화면");
            System.out.println("1 - 주문등록");
            System.out.println("2 - 결제하기");
            System.out.println("3 - 프로그램 종료");
            System.out.println("## 원하는 기능을 선택하세요.");
            return new FeatureType(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputSelectFeature();
        }
    }

    public static int inputTableNumber(OrderStatement orderStatement) {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return orderStatement.checkExistTable(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputTableNumber(orderStatement);
        }
    }

    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요");
            return MenuRepository.checkExistMenu(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputMenuNumber();
        }
    }

    public static int inputCapacity(OrderedMenu orderedMenu) {
        try {
            System.out.println("## 메뉴의 수량을 입력하세요.");
            if (Objects.isNull(orderedMenu)) {
                return Integer.parseInt(scanner.nextLine().trim());
            }
            return orderedMenu.checkPossibleOrder(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputCapacity(orderedMenu);
        }
    }

    public static PaymentType inputPaymentType() {
        try {
            System.out.println("## 1번 테이블의 결제를 진행합니다.");
            System.out.println("## 신용 카드는 1번, 현금은 2번");
            return new PaymentType(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputPaymentType();
        }
    }
}