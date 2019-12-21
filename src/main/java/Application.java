import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Action> actions = ActionRepository.actions();
        boolean roof = true;
        while (roof) {
            OutputView.printActions(actions);
            final int actionNumber = InputView.inputActionNumber();
            roof = actionQuery(actionNumber);
        }
    }

    /**
     * @return 프로그램을 종료할 시 false 를 반환한다.
     */
    public static boolean actionQuery(int actionNumber) {
        if (actionNumber == 1) {
            register();
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

    public static void register() {
        int tableNum = selectTable();
        int menuNum = selectMenu();
        int amount = selectAmount();
        Menu menu = MenuRepository.getMenuByNum(menuNum);
        Order order = new Order(menu, amount);
        TableRepository.addMenuAtTable(tableNum, order);
    }

   public static int selectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    public static int selectMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }

    public static int selectAmount() {
        return InputView.inputAmount();
    }

    public static void pay() {
    }

}
