import domain.Table;
import domain.TableRepository;
import utils.SelectionHandeler;
import view.OutputView;

import java.util.List;

public class OrderController{
    private final List<Table> tables = TableRepository.tables();
    private final int tableNumber;

    public OrderController() {
        OutputView.printTables(tables);
        this.tableNumber = SelectionHandeler.selectTable();
        if(tables.stream().anyMatch(x-> x.isCorrectTable(tableNumber))) {
            // 테이블이 있음
        }
    }
}
