import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public static int getProgramIndex() {
        OutputView.printProgramCategory();
        String inputProgramCategory = InputView.inputProgramCategory();
        int index = ProgramCategory.getProgramIndex(inputProgramCategory);
        if (index == -1) {
            System.out.println();
            return getProgramIndex();
        }
        return index;
    }
}
