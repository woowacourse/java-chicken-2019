package domain;

import view.InputView;
import view.OutputView;

public class ChichenPoS implements PoS {

    private TableService tableService;
    private MenuService menuService;

    public ChichenPoS(TableService tableService) {
        this.tableService = tableService;
    }

    @Override
    public void handle() {
        showMain();
        final int tableNumber = InputView.inputTableNumber();

        if (tableNumber == Requests.Register.getValue()) {
            tableService.showTables();
            OutputView.printRequestForTable();
            menuService.showMenues();
            OutputView.printRequestForMenu();
            int menuNumber = InputView.inputMenuNumber();
            int menuAmount = InputView.inputMenuAmount();

        }

        if (tableNumber == Requests.Pay.getValue()) {

        }

        if (tableNumber == Requests.Exit.getValue()) {

        }

    }

    private void showMain() {
        OutputView.printMain();
    }
}
