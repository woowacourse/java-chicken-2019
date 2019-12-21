package view;

import domain.MenuRepository;
import domain.TableRepository;
import domain.reserved.OrderedMenu;
import domain.reserved.OrderedMenus;
import domain.reserved.TableOrderStatement;

import java.util.Objects;
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

    public static int inputMenuNumber() {
        try {
            System.out.println("## 등록할 메뉴를 선택하세요");
            return MenuRepository.checkExistMenu(Integer.parseInt(scanner.nextLine().trim()));
        } catch (IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            return inputTableNumber();
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
            return inputTableNumber();
        }
    }
}