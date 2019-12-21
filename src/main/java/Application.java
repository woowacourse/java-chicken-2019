import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        boolean roof = true;
        while (roof) {
            final List<Action> actions = ActionRepository.actions();
            OutputView.printActions(actions);
            final int actionNumber = InputView.inputActionNumber();
            roof = ActionQuery(actionNumber);
        }
    }

    /**
     * @return 프로그램을 종료할 시 false 를 반환한다.
     */
    public static boolean ActionQuery(int actionNumber) {
        if (actionNumber == 1) {
            int table = SelectTable();
            return true;
        }
        if (actionNumber == 2) {
            pay();
            return true;
        }
        if (actionNumber == 3) {
            return false;
        }

        throw new IllegalArgumentException("메인화면에서 입력은 1, 2, 3 중 하나여야 합니다.");
    }

    public static int SelectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    public static int SelectMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }

    public static int SelectAmount() {
        return InputView.inputAmount();
    }

    public static void pay() {
    }

}
