package domain;

import view.InputView;
import view.OutputView;

public class ChichenPoS implements PoS {

    private TableService tableService;

    public ChichenPoS(TableService tableService) {
        this.tableService = tableService;
    }

    @Override
    public void handle() {
        OutputView.printMain();

        int funcNumber = InputView.inputFunctionNumber();

        if (funcNumber == Requests.Register.getValue()) {
            tableService.register();
            handle();
            return;
        }

        if (funcNumber == Requests.Pay.getValue()) {
            tableService.pay();
            handle();
            return;
        }

        if (funcNumber == Requests.Exit.getValue()) {
            OutputView.printExit();
            System.exit(0);
        }

    }
}
