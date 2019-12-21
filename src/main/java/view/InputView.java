package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import domain.Functions;
import domain.Table;


public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_TABLE_NUMBER = "## 주문할 테이블을 입력하세요.";
    private static final String ERROR_FORMAT = "잘못된 입력입니다. 숫자로 입력해주세요.";
    private static final String INPUT_FUNCTION_NUMBER = "##원하는 기능을 입력하세요.";
    private static final String ERROR_NUMBER = "잘못된 번호입니다. 다시 입력해주세요.";

    public static int inputFunctionNumber() throws IOException {
        System.out.println(INPUT_FUNCTION_NUMBER);
        try {
            return checkFunctionNumber(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputFunctionNumber();
        }
    }

    private static int checkFunctionNumber(int functionNumber) throws IOException {
        if(functionNumber != Functions.EXIT.getNumber()
                && functionNumber != Functions.PAY.getNumber()
                && functionNumber != Functions.REGISTER.getNumber()){
            System.out.println(ERROR_NUMBER);
            return inputFunctionNumber();
        }
        return functionNumber;
    }

    public static int inputTableNumber(List<Table> tables) throws IOException {
        System.out.println(INPUT_TABLE_NUMBER);
        try {
            return checkTableNumber(Integer.parseInt(BR.readLine().trim()),tables);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputTableNumber(tables);
        }
    }

    private static int checkTableNumber(int tableNumber, List<Table> tables) throws IOException {
        if(tables.stream().anyMatch(s->s.getNumber()==tableNumber))
            return tableNumber;
        System.out.println(ERROR_NUMBER);
        return inputTableNumber(tables);
    }


}
