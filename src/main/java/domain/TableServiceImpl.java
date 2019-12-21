package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class TableServiceImpl implements TableService {
    private List<Table> tables;

    public TableServiceImpl(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public void showTables() {
        OutputView.printTables(tables);

    }
}
