package domain;

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

    private void selectTable(int tableNumber) {
        int index = TableRepository.searchTableIndex(tableNumber);
        tableStatus[index] = true;
        OutputView.printTableSelectSuccess(tableNumber);
    }

    public void clearTable(int tableNumber) {
        int index = TableRepository.searchTableIndex(tableNumber);
        tableStatus[index] = false;
    }

    private boolean isUsableTable(int tableNumber) {
        int index = TableRepository.searchTableIndex(tableNumber);
        return tableStatus[index];
    }

    private int inputTableNumber() {
        String input = "";

        do {
            input = InputView.inputTableNumber();
        } while (!InputValidator.isNumber(input));

        return Integer.parseInt(input);
    }

    public void choiceTable() {
        OutputView.printTables(tables);
        int tableNumber = inputTableNumber();

        while (!TableRepository.isExist(tableNumber) || isUsableTable(tableNumber)) {
            OutputView.printTableSelectFail();
            tableNumber = inputTableNumber();
        }
        selectTable(tableNumber);
    }
}
