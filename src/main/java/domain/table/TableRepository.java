package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.ErrorMessage.INVALID_TABLE_NUMBER;

/**
 * 데이터를 조회하는 DB역할
 * 기존 코드 수정 불가능
 * 기존 코드에서 추가는 가능
 */

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findByTableNumber(final Integer tableNumber) {
        return tables().stream()
                .filter(c -> c.getNumber().equals(tableNumber))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INVALID_TABLE_NUMBER);
                });
    }
}
