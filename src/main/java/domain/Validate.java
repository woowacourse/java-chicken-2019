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

    public static boolean validateYesOrNo(String input) {
        if (input.length() != 1)
            return false;

        char yesOrNo = Character.toLowerCase(input.charAt(0));
        if (yesOrNo != 'y' && yesOrNo != 'n' ) {
            System.out.println("잘못 입력하셨습니다.");
            return false;
        }
        return true;
    }
}
