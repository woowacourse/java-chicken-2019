package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {

    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int EXIT = 3;

    final List<Table> tables = TableRepository.tables();;
    final List<Menu> menus = MenuRepository.menus();

    public GameController() {

    }

    public void gameStart() {
        int answer = 0;
        while (answer != EXIT) {
            OutputView.printMainMenu();
            answer = InputView.inputMainFunction();
            if (answer == ORDER)
                tableOrder();
            if (answer == PAYMENT)
                tablePayment();
        }
    }

    private void tableOrder() {
        OutputView.printTables(tables);
        InputView.inputTableNumber();
        OutputView.printMenus(menus);
        InputView.inputMenuNumber();
        InputView.inputMenuQuantityNumber();
    }

    private void tablePayment() {
        OutputView.printTables(tables);
        InputView.inputTableNumber();
        OutputView.printOrderHistory();
        InputView.inputCardOrCash(1);
        OutputView.printFinalPaymontAmount();
    }

}
