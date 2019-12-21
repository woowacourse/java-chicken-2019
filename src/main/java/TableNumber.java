import domain.Table;
import domain.TableRepository;

public class TableNumber {
    private final int tableNumber;

    public TableNumber(int tableNumber) {
        if (!TableRepository.tables().contains(new Table(tableNumber))) {
            throw new IllegalArgumentException("테이블 번호를 잘못 입력하셨습니다.");
        }
        this.tableNumber = tableNumber;
    }
}