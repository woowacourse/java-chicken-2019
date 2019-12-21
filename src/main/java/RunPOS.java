import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RunPOS {

    private final Table table;

    public RunPOS(int action) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        table = TableRepository.getTable(tableNumber);
    }

    /**
     * 주문등록 담당
     */
    public void order() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Menu menu = InputView.inputOrderMenu();
        int count = InputView.inputOrderCount();
        table.addMenus(menu, count);

    }

    /**
     * 결제하기 담당
     */
    public void pay() {
    }



}
