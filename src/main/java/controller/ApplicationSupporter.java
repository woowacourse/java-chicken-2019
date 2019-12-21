package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ApplicationSupporter {
    private static final int ADD_MENU = 1;
    private static final int CHECK_OUT = 2;
    private static final int END_PROGRAM = 3;

    public void mainOptionPhase() {
        OutputView.printMainOption();
        final int optionChoice = InputView.inputMainOption();
        if (optionChoice == ADD_MENU) {
            addMenuPhase();
        }
        if (optionChoice == CHECK_OUT) {
            checkOutPhase();
        }
        if (optionChoice == END_PROGRAM) {
            OutputView.printEndMessage();
            System.exit(0);
        }
    }

    public void addMenuPhase() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public void checkOutPhase() {

    }
}
