package domain;

public class TableNumber {
    private final int tableNumber;

    public TableNumber(String inputString) {
        int tableNumber;
        try {
            tableNumber =  Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("※ 숫자만 입력 가능합니다.");
        }
        if (TableRepository.doesNotExistTableNumber(tableNumber)) {
            throw new IllegalArgumentException("※ 존재하는 테이블 번호만 입력 가능합니다.");
        }
        this.tableNumber = tableNumber;
    }

    public int get() {
        return tableNumber;
    }
}
