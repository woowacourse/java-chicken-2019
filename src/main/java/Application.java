import domain.*;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {

        // 장바구니, 테이블 , 메뉴
        final List<Order> orderList = new ArrayList<>();
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        // 메인 메뉴 출력
        OutputView.printPosMenu();
        int posChoice = validatePosChoice();

        // 테이블 상태 출력
        OutputView.printTables(tables);

        // 주문 등록 로직
        if (posChoice == 1) {
            final int tableNumber = validateTableNumber();
            OutputView.printMenus(menus);
            int foodNumber = validateFoodNumber(menus);
            int foodCount = validateFoodCount();
            orderList.add(new Order(foodNumber, foodCount));
        }
    }

    /** 조건 분리 */
    private static int validateFoodCount() {
        try {
            int foodCount = InputView.inputFoodCount();
            if (foodCount <= 0) {
                throw new IllegalArgumentException("1개 이상 주문해 주세요");
            }
            if (foodCount > 99) {
                throw new IllegalArgumentException("최대 주문 가능 수량을 초과했습니다.");
            }
            return foodCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validateFoodCount();
    }

    private static int validateFoodNumber(List<Menu> menus) {
        try {
            int foodNumber = InputView.inputFoodNumber();
            if (menus.stream().filter(m -> m.isMatchNumber(foodNumber)).count() == 0){
                throw new IllegalArgumentException("선택 가능한 메뉴가 아닙니다.");
            }
            return foodNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validateFoodNumber(menus);
    }

    private static int validateTableNumber() {
        try {
            int tableNumber = InputView.inputTableNumber();
            if (tableNumber < 0 | tableNumber > 8) {
                throw new IllegalArgumentException("선택 가능한 범위가 아닙니다.");
            }
            return tableNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validateTableNumber();
    }

    public static int validatePosChoice() {
        try {
            int posChoice = InputView.inputPosChoice();
            if (posChoice < 0 | posChoice > 3) {
                throw new IllegalArgumentException("선택 가능한 범위가 아닙니다.");
            }
            return posChoice;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validatePosChoice();
    }
}
