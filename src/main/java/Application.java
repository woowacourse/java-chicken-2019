import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.PosNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        SelectPosMenu(InputView.inputPosMenu());
    }

    private static void SelectPosMenu(int posNumber) {
        if(new PosNumber(posNumber).isOptionOne()) {
            SelectOneOption();
        }
        if(new PosNumber(posNumber).isOptionTwo()) {
            SelectTwoOption();
        }
        if(new PosNumber(posNumber).isOptionThree()) {
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
