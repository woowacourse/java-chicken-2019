import domain.*;
import view.InputView;
import view.OutputView;

import javax.swing.border.AbstractBorder;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        boolean isProgress = true;

        do {
            int mainNumber = InputView.inputMainNumber();
            if (mainNumber == 1) {
                orderSelect();
            }
            if (mainNumber == 2) {
                paymentSelect();
            }
            if (mainNumber == 3) {
                OutputView.programExit();
                isProgress = false;
            }
        } while (isProgress);
    }

    public static void orderSelect() {
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public static void paymentSelect() {

    }

}
