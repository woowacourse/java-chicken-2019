package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import domain.Functions;


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
                || functionNumber != Functions.PAY.getNumber()
                || functionNumber != Functions.REGISTER.getNumber()){
            System.out.println(ERROR_NUMBER);
            return inputFunctionNumber();
        }
        return functionNumber;
    }

    public static int inputTableNumber() throws IOException {
        System.out.println(INPUT_TABLE_NUMBER);
        try {
            return checkTableNumber(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputTableNumber();
        }
    }


}
