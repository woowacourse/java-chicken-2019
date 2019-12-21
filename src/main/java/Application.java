import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while(true){
            int programIndex = getProgramIndex();
            if (programIndex == 3)
                break;
            int tableIndex = getTableNumber();
            if (programIndex == 1)
                Order.getOrder(tableIndex);
        }
    }

    public static int getProgramIndex() {
        OutputView.printProgramCategory();
        System.out.println();
        String inputProgramCategory = InputView.inputProgramCategory();
        int index = ProgramCategory.getProgramIndex(inputProgramCategory);
        if (index == -1) {
            System.out.println();
            return getProgramIndex();
        }
        return index;
    }

    public static int getTableNumber() {
        OutputView.printTables(getTables());
        final String tableInput = InputView.inputTableNumber();
        if (TableRepository.validateTableInput(tableInput)) {
            return Integer.parseInt(tableInput);
        }
        return getTableNumber();
    }

    public static List<Table> getTables() {
        return tables;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
