package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static Table findByTableNumber(int number) {
        if (!containsByTableNumber(number)) {
            throw new IllegalArgumentException(number + "번 테이블이 존재하지 않습니다.");
        }
        return tables().stream()
                .filter(table -> table.isMatchNumber(number))
                .findFirst().get();
    }

    public static boolean containsByTableNumber(int number) {
        return tables.stream()
                .anyMatch(table -> table.isMatchNumber(number));
    }
}
