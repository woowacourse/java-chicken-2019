package domain;

/**
 * 입력에 대한 검증을 하는 객체
 */
public class Validate {
    static int validateNumber(String inputNumber){
        int number = -1;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (Exception e) {
            number = -1;
        }
        return number;
    }
}
