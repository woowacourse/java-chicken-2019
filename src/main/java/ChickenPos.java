import domain.MenuRepository;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

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
        OutputView.printTables(TableRepository.tables());
        if (selectMenu(select)) {
            int tableNumber = InputView.inputTableNumber();
            OutputView.printMenus(MenuRepository.menus());
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
