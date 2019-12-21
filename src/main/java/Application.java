import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    private static final int OPTION_ONE = 1;
    private static final int OPTION_TWO = 2;
    private static final int OPTION_THREE = 3;

    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        SelectPosMenu(InputView.inputPosMenu());
    }

    private static void SelectPosMenu(int posNumber) {
        if(posNumber == OPTION_ONE) {
            SelectOneOption();
        }
        if(posNumber == OPTION_TWO) {
            SelectTwoOption();
        }
        if(posNumber == OPTION_THREE) {
            SelectThreeOption();
        }
    }

    private static final int selectTable() {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    private static void SelectOneOption() {
        selectTable();
        OutputView.printMenus(menus);
    }

    private static void SelectTwoOption() {
        selectTable();
    }

    private static void SelectThreeOption() {
    }

}
