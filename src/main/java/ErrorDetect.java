import view.InputView;

import java.util.Objects;

public class ErrorDetect {

    public static final void mainInputError(int number) {
        while (number < 1 || number > 3) {
            System.out.println("1, 2, 3 중 선택해주세요.");
            number = InputView.inputMain();
        }
    }
}
