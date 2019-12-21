import domain.MainMenu;
import domain.MainMenuRepository;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.InvalidInputException;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<MainMenu> mainMenus = MainMenuRepository.mainMenus();
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        run(tables, menus, mainMenus);
    }

    private static void run(List<Table> tables, List<Menu> menus, List<MainMenu> mainMenus) {
        boolean isQuit = false;

        while (!isQuit) {
            try {
                MainMenu mainMenu = takeMainMenuFromUser(mainMenus);
                isQuit = mainMenu.isQuit();
                runProgram(tables, menus, mainMenu);
            } catch (InputMismatchException ime) {
                throw new InvalidInputException(InvalidInputException.NOT_NUMBER_EXCEPTION);
            } catch (InvalidInputException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    private static MainMenu takeMainMenuFromUser(List<MainMenu> mainMenus) {
        OutputView.printMain();
        int mainMenuNumber = InputView.inputMainMenuNumber();
        return mainMenus.stream().filter(mainMenu -> mainMenu.isSameMenu(mainMenuNumber)).findFirst()
                .orElseThrow(() -> new InvalidInputException(InvalidInputException.WRONG_MAIN_MENU_NUMBER_EXCEPTION));
    }

    private static void runProgram(List<Table> tables, List<Menu> menus, MainMenu mainMenu) {
        if (mainMenu.isOrder()) {
            runOrder(tables, menus);
        }
        if (mainMenu.isPay()) {
            runPay(tables);
        }
    }

    private static void runOrder(List<Table> tables, List<Menu> menus) {
        Table selectedTable = takeTableFromUser(tables);
        int menuNumber = takeMenuFromUser(menus);
        Menu menuToAdd = menus.stream().filter(menu -> menu.isSameMenu(menuNumber)).findAny()
                .orElseThrow(() -> new InvalidInputException(InvalidInputException.WRONG_MENU_NUMBER_EXCEPTION));
        int menuCount = InputView.inputMenuCount();
        selectedTable.addMenu(menuToAdd, menuCount);
    }

    private static void runPay(List<Table> tables) {
        Table selectedTable = takeTableFromUser(tables);
        OutputView.printOrders(selectedTable);
        int paymentWay = InputView.inputPaymentWay();
        OutputView.printPrices(selectedTable);
        selectedTable.initTableMenu();
    }

    private static Table takeTableFromUser(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        return tables.stream().filter(table -> table.isSameTable(tableNumber)).findFirst()
                .orElseThrow(() -> new InvalidInputException(InvalidInputException.WRONG_TABLE_NUMBER_EXCEPTION));
    }

    private static int takeMenuFromUser(List<Menu> menus) {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }
}
