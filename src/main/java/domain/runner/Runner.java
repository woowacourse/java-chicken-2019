package domain.runner;

import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;

public class Runner {
    protected static Table inputTableInfo() {
        int tableNumber = InputView.inputTableNumber();
        return TableRepository.findByTableNumber(tableNumber);
    }
}
