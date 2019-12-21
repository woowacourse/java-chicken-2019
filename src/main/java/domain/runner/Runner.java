package domain.runner;

import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;

public class Runner {
    protected static Table getTableByNumber() {
        try {
            return TableRepository.findByTableNumber(InputView.inputTableNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorRetryMessage(e);
            return getTableByNumber();
        }
    }
}
