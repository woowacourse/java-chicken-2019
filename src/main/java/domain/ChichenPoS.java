package domain;

import view.InputView;
import view.OutputView;

public class ChichenPoS implements PoS {

    private TableService tableService;
    private InputView inputView;

    public ChichenPoS(TableService tableService, InputView inputView) {
        this.tableService = tableService;
        this.inputView = inputView;
    }

    @Override
    public void handle() {
        OutputView.printMain();
        int funcNumber = inputView.inputFunctionNumber();
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
