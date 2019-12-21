import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    final static ShoppingBasket shoppingBasket = new ShoppingBasket();
    final static List<Action> actions = ActionRepository.actions();
    final static List<Table> tables = TableRepository.tables();
    final static List<Menu> menus = MenuRepository.menus();

    // TODO 구현 진행
    public static void main(String[] args) {
        boolean roof = true;
        while (roof) {
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
            registerOrder();
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

    public static void registerOrder() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
    }

    public static void pay() {
        OutputView.printMenus(menus);
    }

}
