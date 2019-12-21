import domain.Menu;
import domain.MenuRepository;
import utils.ErrorHandeler;
import utils.OrderController;
import utils.SelectionHandeler;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        do {

        } while (!mainMenu());
    }

    private static boolean mainMenu() {
        OutputView.printMainMenu();
        final int menuNumber = SelectionHandeler.selectFunction();
        if (menuNumber == 1) {
            ErrorHandeler.makeOrderController();
        }
        if(menuNumber == 2) {
        }
        if(menuNumber == 3) {
            return false;
        }
        return true;
    }
}
