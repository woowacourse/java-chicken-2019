package view;

import domain.MenuRepository;
import domain.TableRepository;
import domain.reserved.OrderedMenu;
import view.dto.FeatureType;

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

    public static int inputTableNumber() {
        try {
            System.out.println("## 주문할 테이블을 선택하세요.");
            return TableRepository.checkExistTable(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputTableNumber();
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
}