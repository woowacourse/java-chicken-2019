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

        while (true) {
            MainMenu mainMenu = takeMainMenuFromUser(mainMenus);
            if (mainMenu.isQuit()) {
                break;
            }
            runProgram(tables, menus, mainMenu);
        }
    }

    private static MainMenu takeMainMenuFromUser(List<MainMenu> mainMenus) {
        try {
            OutputView.printMain();
            int mainMenuNumber = InputView.inputMainMenuNumber();
            return mainMenus.stream().filter(mainMenu -> mainMenu.isSameMenu(mainMenuNumber)).findFirst()
                    .orElseThrow(() -> new InvalidInputException("메인 메뉴를 잘못 선택하셨습니다."));
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
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
        OutputView.printMenus(menus);
        int menuNumber = takeMenuFromUser(menus);
        Menu menuToAdd = menus.stream().filter(menu -> menu.isSameMenu(menuNumber)).findAny()
                .orElseThrow(() -> new InvalidInputException("존재하지 않는 메뉴를 입력하셨습니다."));
        int menuCount = takeMenuCountFromUser();
        selectedTable.addMenu(menuToAdd, menuCount);
    }

    private static void runPay(List<Table> tables) {
        Table selectedTable = takeTableFromUser(tables);
        OutputView.printOrders(selectedTable);
        int paymentWay = InputView.inputPaymentWay();
        OutputView.printPrices(selectedTable);
    }

    private static Table takeTableFromUser(List<Table> tables) {
        try {
            OutputView.printTables(tables);
            int tableNumber = InputView.inputTableNumber();
            return tables.stream().filter(table -> table.isSameTable(tableNumber)).findFirst()
                    .orElseThrow(() -> new InvalidInputException("존재하지 않는 테이블 번호입니다."));
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static int takeMenuFromUser(List<Menu> menus) {
        try {
            OutputView.printMenus(menus);
            int menuNumber = InputView.inputMenuNumber();
            return menuNumber;
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static int takeMenuCountFromUser() {
        try {
            int menuCount = InputView.inputMenuCount();
            validateMenuCount(menuCount);
            return menuCount;
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static void validateMenuCount(int menuCount) {
        if (menuCount < 0) {
            throw new InvalidInputException("메뉴 수량은 0미만일 수 없습니다.");
        }
    }

}
