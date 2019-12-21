import utils.ErrorHandeler;
import utils.SelectionHandeler;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        boolean isContinue = true;
        do {
            isContinue = mainMenu();
        } while (isContinue);
    }

    private static boolean mainMenu() {
        OutputView.printMainMenu();
        final int menuNumber = SelectionHandeler.selectFunction();
        if (menuNumber == 1) {
            ErrorHandeler.makeOrderController();
        }
        if (menuNumber == 2) {
            ErrorHandeler.makePaymentController();
        }
        if (menuNumber == 3) {
            return false;
        }
        return true;
    }
}
