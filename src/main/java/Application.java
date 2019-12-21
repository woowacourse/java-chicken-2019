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
        while (true) {
            final List<Table> tables = TableRepository.tables();
            final List<Menu> menus = MenuRepository.menus();

            int mainMenu = takeMainMenuFromUser();
            if (mainMenu == 3) {
                break;
            }
            runProgram(tables, menus, mainMenu);

        }
    }

    private static int takeMainMenuFromUser() {
        try {
            OutputView.printMain();
            int mainMenu = InputView.inputMainMenuNumber();
            validateMainNumber(mainMenu);
            return mainMenu;
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static void validateMainNumber(int mainMenu) {
        if (mainMenu != 1 && mainMenu != 2 && mainMenu != 3) {
            throw new InvalidInputException("메인 메뉴는 1, 2, 3 중 하나를 선택해주세요");
        }
    }

    private static void runProgram(List<Table> tables, List<Menu> menus, int mainMenu) {
        int tableNumber = takeTableNumberFromUser(tables);

        if (mainMenu == 1) {
            OutputView.printMenus(menus);
            int menuNumber = takeMenuFromUser(menus);
            int menuCount = takeMenuCountFromUser();
            return;
        }

    }

    private static int takeTableNumberFromUser(List<Table> tables) {
        try {
            OutputView.printTables(tables);
            int tableNumber = InputView.inputTableNumber();
            validateTableNumber(tableNumber, tables);
            return tableNumber;
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static void validateTableNumber(int tableNumber, List<Table> tables) {
        if (!(0 < tableNumber && tableNumber <= tables.size())) {
            throw new InvalidInputException("테이블의 크기는 ~이하입니다.");
        }
    }

    private static int takeMenuFromUser(List<Menu> menus) {
        try {
            OutputView.printMenus(menus);
            int menuNumber = InputView.inputMenuNumber();
            validateMenuNumber(menuNumber, menus);
            return menuNumber;
        } catch (InputMismatchException ime) {
            throw new InvalidInputException("숫자가 아닌 값을 입력하실 수 없습니다.");
        }
    }

    private static void validateMenuNumber(int menuNumber, List<Menu> menus) {
        if (!menus.stream().anyMatch(menu -> menu.getNumber() == menuNumber)) {
            throw new InvalidInputException("존재하지 않는 메뉴를 입력하셨습니다.");
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
