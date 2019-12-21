import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenPos {
    private static final int MENU = 1;
    private static final int PAYMENT = 2;
    private static final int OFF = 3;

    private final List<Table> tables;
    private final List<Menu> menus;

    public ChickenPos(List<Table> tables, List<Menu> menus) {
        this.tables = tables;
        this.menus = menus;
    }

    public static ChickenPos init() {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        return new ChickenPos(tables, menus);
    }

    public void on() {
        int selectNumber = InputView.inputMainMenu();
        while (untilOff(selectNumber)) {
            doSelection(selectNumber);

            selectNumber = InputView.inputMainMenu();
        }
    }

    private boolean untilOff(int select) {
        return select != OFF;
    }

    private void doSelection(int select) {
        OutputView.printTables(tables);
        if (selectMenu(select)) {
            int tableNumber = InputView.inputTableNumber();
            OutputView.printMenus(menus);
            int menuNumber = InputView.inputMenuNumber();
            int menuSize = InputView.inputMenuAmount();
            // 테이블에 주문 추가하기
            return;
        }
        //테이블 가격계산하기

    }

    private boolean selectMenu(int select) {
        return select == MENU;
    }

}
