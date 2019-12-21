import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        Application application = new Application();
        application.mainMenu();
        application.tableMenu(tables);
        application.menuMenu(menus);
        application.quantityMenu();
    }

    private int mainMenu() {
        OutputView.printMainMenu();
        int mainMenuNumber = InputView.inputMainMenuNumber();
        if (mainMenuNumber == 3) {
            System.out.println("\nPOS 프로그램을 종료합니다.");
            System.exit(0);
        }
        return mainMenuNumber;
    }

    private int tableMenu(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        return tableNumber;
    }

    private int menuMenu(List<Menu> menus) {
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        return menuNumber;
    }

    private int quantityMenu() {
        int quantityNumber = InputView.inputQuantityNumber();
        return quantityNumber;
    }
}
