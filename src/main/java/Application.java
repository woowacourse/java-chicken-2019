import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Action> actions = ActionRepository.actions();
        OutputView.printActions(actions);
        final int actionNumber = InputView.inputActionNumber();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

}
