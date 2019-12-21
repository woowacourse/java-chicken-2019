package domain;

import domain.model.Table;
import domain.repository.TableRepository;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * 테이블 관리자 역할의 클래스
 */
public class TableManager {
    private List<Table> tables = TableRepository.tables();
    private boolean[] tableStatus = new boolean[tables.size()];

    private void inputTable(int tableNumber, boolean printGuide) {
        int index = TableRepository.search(tableNumber);
        if (printGuide && !tableStatus[index]) {
            OutputView.printTableSelectSuccess(tableNumber);
        }
        tableStatus[index] = true;
    }

    public void clearTable(int tableNumber) {
        int index = TableRepository.search(tableNumber);
        tableStatus[index] = false;
    }

    private boolean isNewTable(int tableNumber) {
        int index = TableRepository.search(tableNumber);
        return tableStatus[index];
    }

    private int inputTableNumber() {
        String input = "";

        do {
            input = InputView.inputTableNumber();
        } while (!InputValidator.isNumberInRange(input, Integer.MAX_VALUE));

        return Integer.parseInt(input);
    }

    public int selectTable(boolean printGuide) {
        OutputView.printTables(tables);
        int tableNumber = inputTableNumber();

        while (!TableRepository.isExist(tableNumber)) {
            OutputView.printTableSelectFail();
            tableNumber = inputTableNumber();
        }
        inputTable(tableNumber, printGuide);
        return tableNumber;
    }
}
