import view.InputView;

public class ErrorDetect {

    public static final void mainSelectError(int number) {
        while (number < 1 || number > 3) {
            System.out.println("잘못된 입력입니다. 1, 2, 3 중 선택하세요.");
            number = InputView.inputMain();
        }
    }
}
