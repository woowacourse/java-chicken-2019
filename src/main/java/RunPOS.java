import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RunPOS {

    private final List<Table> tables;
    private final List<Menu> menus;
    private final int tableNumber;

    public RunPOS(int action) {
        tables = TableRepository.tables();
        menus = MenuRepository.menus();

        OutputView.printTables(tables);

        tableNumber = InputView.inputTableNumber();

        if (action == 1) order();
        if (action == 2) pay();
    }

    /**
     * 주문등록 담당
     */
    public void order() {
        OutputView.printMenus(menus);

        Menu menu = InputView.inputOrderMenu();

    }

    /**
     * 결제하기 담당
     */
    public void pay() {
    }



}
