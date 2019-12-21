package domain;

import view.InputView;
import view.OutputView;

public class ChichenPoS implements PoS {

    private TableService tableService;
    private InputView inputView;
    private OutputView outputView;

    public ChichenPoS(TableService tableService, InputView inputView, OutputView outputView) {
        this.tableService = tableService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void handle() {
        outputView.printMain();

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
            outputView.printExit();
            System.exit(0);
        }

    }
}
