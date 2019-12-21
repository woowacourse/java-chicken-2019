package exception;

public class TableNumber {
    private int number = 0;

    private final int NULL_VALUE = 0;
    private final int[] right_table = {1, 2, 3, 5, 6, 8};

    public TableNumber(int number) {
        if (number == NULL_VALUE) {
            throw new IllegalArgumentException("테이블을 선택하지 않았습니다. 테이블을 선택해주세요.");
        }
        for (int index = 0; index < right_table.length; index ++) {
            if (number != right_table[index]) {
                throw new IllegalArgumentException("존재하는 테이블이 아닙니다. 존재하는 테이블을 선택해주세요.");
            }
        }
        this.number = number;
    }

    public int getTableNumber() {
        return this.number;
    }
}
