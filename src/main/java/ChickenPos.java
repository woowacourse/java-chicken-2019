import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.NoSuchElementException;

public class ChickenPos {
    private static final int MENU = 1;
    private static final int PAYMENT = 2;
    private static final int OFF = 3;

    private ChickenPos() {
    }

    public static ChickenPos init() {
        return new ChickenPos();
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
        Table table = getTable();

        if (selectMenu(select)) {
            Menu menu = getMenu();
            int menuSize = InputView.inputMenuAmount();
            // 테이블에 주문 추가하기
            return;
        }
        //테이블 가격계산하기

    }

    private Table getTable() {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = InputView.inputTableNumber();
        try {
            return TableRepository.findById(tableNumber);
        } catch (NoSuchElementException e) {
            return getTable();
        }
    }

    private Menu getMenu() {
        OutputView.printMenus(MenuRepository.menus());
        int menuNumber = InputView.inputMenuNumber();
        try {
            return MenuRepository.findById(menuNumber);
        } catch (NoSuchElementException e) {
            return getMenu();
        }
    }

    private boolean selectMenu(int select) {
        return select == MENU;
    }

}
