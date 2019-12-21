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
        final int action = InputView.inputMain();
        ErrorDetect.mainSelectError(action);
        actionLogic(action);

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public static void actionLogic(int action) {
        if (action == 1)
            order();
        if (action == 2)
            pay();
    }

    /**
     * 주문등록 담당
     */
    public static void order() {

    }

    /**
     * 결제하기 담당
     */
    public static void pay() {

    }

}
