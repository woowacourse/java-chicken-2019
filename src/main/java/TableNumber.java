import domain.Table;
import domain.TableRepository;

public class TableNumber {
    private final int tableNumber;
    private final Table table;

    public TableNumber(int tableNumber) {
        if ((table = TableRepository.getTable(tableNumber)) == null) {
            throw new IllegalArgumentException("테이블 번호를 잘못 입력하셨습니다.");
        }
        this.tableNumber = tableNumber;
    }

    public Table getTable() {
        return table;
    }
}