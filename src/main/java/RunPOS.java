import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 주문과 결제를 담당하는 클래스.
 * 전반적인 로직이 구현되어 있다.
 */
public class RunPOS {

    private final Table table;

    public RunPOS() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        table = TableRepository.getTable(tableNumber);
    }

    /**
     * 주문 등록을 담당하는 메소드
     * 사용자가 고른 메뉴를 해당 테이블에 추가한다.
     */
    public void order() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Menu menu = InputView.inputOrderMenu();
        int count = InputView.inputOrderCount(table, menu);
        table.addMenus(menu, count);
    }

    /**
     * 결제를 담당하는 메소드
     */
    public void pay() {
        OutputView.printOrderedMenus(table);
    }



}
