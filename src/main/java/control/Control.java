package control;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Control {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    private static List<Pay> payList = PayList.List();


    public static void payAndSelect() {
        int key = 0;
        while (key != 3) {
            OutputView.printFunction();
            key = InputView.inputFunctionNumber();
            switchFunction(key);
        }
    }

    private static void switchFunction(int key) {
        if (key == 1) {
            selectTable();
        } else if (key == 2) {
            payLoad();
        } else if (key == 3) {
            //정상종료
        } else {
            // 오류종료
        }
    }

    private static void selectTable() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        registMenu(tableNumber);
    }

    private static void registMenu(int tableNumber) {
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
    }

    private static void payLoad() {

    }
}
