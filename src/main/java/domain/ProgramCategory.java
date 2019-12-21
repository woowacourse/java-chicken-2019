package domain;

import java.util.Arrays;
import java.util.List;

/**
 * 프로그램의 종류
 */
public class ProgramCategory {
    private static List<String> programCategory = Arrays.asList("주문등록", "결제하기", "프로그램 종료");

    public static int getProgramIndex(String inputProgramCategory) {
        int index = -1;
        try {
            index = Integer.parseInt(inputProgramCategory);
        } catch (Exception e) {
            index = -1;
        }
        if(index < 1 || index > programCategory.size()) {
            index = -1;
            System.out.println("잘못입력하셨습니다.");
        }
        return index;
    }

    public static List<String> getProgramCategory(){
        return programCategory;
    }
}
