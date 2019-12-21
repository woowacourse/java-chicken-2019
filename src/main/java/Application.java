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
            int mainMenu = takeMainMenuFromUser();

            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);

            final int tableNumber = InputView.inputTableNumber();

            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
        }
    }

    private static int takeMainMenuFromUser() {
        try {
            OutputView.printMain();
            int mainMenu = InputView.inputMainNumber();
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
}
