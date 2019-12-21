import controller.OrderController;
import domain.MainMenu;
import domain.MainMenuRepository;
import domain.TableRepository;
import domain.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());

        final List<MainMenu> mainMenus = MainMenuRepository.mainMenus();
        OutputView.printMainMenu(mainMenus);

        final int mainMenuNumber = InputView.inputMainMenuNumber();

        if (mainMenuNumber == 1) {
            OrderController orderController = new OrderController(tables);
            orderController.run();
        }

    }
}
