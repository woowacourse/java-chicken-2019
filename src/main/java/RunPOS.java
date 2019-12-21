import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RunPOS {

    private final int tableNumber;

    public RunPOS(int action) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        tableNumber = InputView.inputTableNumber();

        if (action == 1) order();
        if (action == 2) pay();
    }

    /**
     * 주문등록 담당
     */
    public void order() {

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    /**
     * 결제하기 담당
     */
    public void pay() {
    }

}
