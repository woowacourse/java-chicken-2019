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

        final int funcNumber = InputView.inputFunctionNumber();

        if (funcNumber == Requests.Register.getValue()) {
            tableService.register();
            handle();
            return;
        }

        if (funcNumber == Requests.Pay.getValue()) {

        }

        if (funcNumber == Requests.Exit.getValue()) {
            OutputView.printExit();
            System.exit(0);
        }

    }

    private void showMain() {
        OutputView.printMain();
    }
}
