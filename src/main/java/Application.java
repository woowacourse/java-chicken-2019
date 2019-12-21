import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        int currentTableNumber = 0;

        Choice posChoice;
        do {
            // 메인 메뉴 출력
            OutputView.printPosMenu();
            posChoice = validatePosChoice();


            // 주문 등록 로직
            if (posChoice == Choice.ORDER) {
                OutputView.printTables(tables, currentTableNumber);
                final int tableNumber = validateTableNumber(tables, currentTableNumber);
                currentTableNumber = tableNumber;
                OutputView.printMenus(menus);
                int foodNumber = validateFoodNumber(menus);
                Menu selectedMenu = menus.stream().filter(m -> m.isMatchNumber(foodNumber)).findAny().get();
                Basket.addToOrderList(selectedMenu, validateFoodCount());
            }

            // 결제 로직
            if (posChoice == Choice.PAY){
                OutputView.printTables(tables, currentTableNumber);
                final int tableNumber = validatePayableTableNumber(currentTableNumber);
                OutputView.printOrderList(Basket.showOrderList());
                OutputView.printPayingStartMessage(tableNumber);

                int totalPrice = Basket.calculateTotalPrice();
                Payment payment = validatePaymentChoice();
                double finalPaymentPrice = payment.calculateFinalDiscountedPrice(totalPrice);
                OutputView.printFinalPaymentPrice(finalPaymentPrice);
            }
        } while(posChoice != Choice.EXIT);

    }

    private static Payment validatePaymentChoice() {
        try {
            int paymentChoice = InputView.inputPaymentChoice();
            if (paymentChoice < 0 | paymentChoice > 2) {
                throw new IllegalArgumentException("선택 가능한 범위가 아닙니다.");
            }
            return Arrays.stream(Payment.values()).filter(p -> p.isMatchPaymentNumber(paymentChoice)).findAny().get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validatePaymentChoice();
    }

    private static int validatePayableTableNumber(int currentTableNumber) {
        try {
            int tableNumber = InputView.inputTableNumber();
            validateOverOne(tableNumber);
            validateCurrentPayableTable(currentTableNumber, tableNumber);
            return tableNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validatePayableTableNumber(currentTableNumber);
    }

    private static void validateCurrentPayableTable(int currentTableNumber, int tableNumber) {
        if (tableNumber != currentTableNumber) {
            throw new IllegalArgumentException("결제 가능한 테이블이 아닙니다.");
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

    private static int validateTableNumber(List<Table> tables, int currentTableNumber) {
        try {
            int tableNumber = InputView.inputTableNumber();
            validateOverOne(tableNumber);
            validateExistedTables(tables, tableNumber);
            validateCurrentOrderingTable(currentTableNumber, tableNumber);
            return tableNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validateTableNumber(tables, currentTableNumber);
    }

    private static void validateOverOne(int tableNumber) {
        if (tableNumber <= 0) {
            throw new IllegalArgumentException("선택 가능한 범위가 아닙니다.");
        }
    }

    private static void validateExistedTables(List<Table> tables, int tableNumber) {
        if (tables.stream().filter(table -> table.isMatchNumber(tableNumber)).count() == 0){
            throw new IllegalArgumentException("존재하는 테이블 번호가 아닙니다.");
        }
    }

    private static void validateCurrentOrderingTable(int currentTableNumber, int tableNumber) {
        if (currentTableNumber != 0 && tableNumber != currentTableNumber){
            throw new IllegalArgumentException("현재 주문 중인 테이블이 아닙니다.");
        }
    }

    public static Choice validatePosChoice() {
        try {
            int posChoice = InputView.inputPosChoice();
            if (posChoice < 0 | posChoice > 3) {
                throw new IllegalArgumentException("선택 가능한 범위가 아닙니다.");
            }
            return Arrays.stream(Choice.values()).filter(c -> c.getPosNumber() == posChoice).findAny().get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return validatePosChoice();
    }
}
