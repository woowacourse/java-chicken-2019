package view;

import domain.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int REGIST_MENU = 1;
    private static final int MAKE_PAYMENT = 2;
    private static final int END_PROGRAM = 3;
    private static int inputNumber;

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputOrderNumber(HashMap<Integer, Integer> orderTable, List<Table> tableList) {
        OutputView.printOrderPage();
        while(!isNumber(orderTable, tableList));
        return inputNumber;
    }

    private static boolean isNumber(HashMap<Integer, Integer> orderTable, List<Table> tableList) {
        try{
            inputNumber = scanner.nextInt();
            checkOrderNumber(inputNumber);
            checkAlreadyOrder(inputNumber, orderTable, tableList);
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.printf("다시 입력해주세요\n\n");
            OutputView.printOrderPage();
        }
        return false;

    }

    private static void checkAlreadyOrder(int inputNumber,HashMap<Integer, Integer> orderTable,
                                          List<Table> tables) throws Exception {
        boolean alreadyOrder = false;
        if(inputNumber != MAKE_PAYMENT) { return; }
        for(Table table : tables) {
            alreadyOrder = orderTable.containsKey(table.getNumber());
            if(alreadyOrder) {
                break;
            }
        }
        if(!alreadyOrder) {
            throw new Exception("결제할 내역이 없습니다.");
        }
    }

    private static void checkOrderNumber(int inputNumber) throws Exception {
        if(inputNumber != REGIST_MENU && inputNumber != MAKE_PAYMENT && inputNumber != END_PROGRAM) {
            throw new IllegalAccessException("메인 화면에 있는 값만 입력해주세요");
       }
    }
}
