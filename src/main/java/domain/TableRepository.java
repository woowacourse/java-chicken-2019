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

    public static boolean validateTableInput(String input) {
        int tableNumber = Validate.validateNumber(input);
        return validateTableNumber(tableNumber);
    }

    public static boolean validateTableNumber(int tableNumber) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getNumber() == tableNumber)
                return true;
        }
        System.out.println("테이블 번호가 잘못되었습니다.\n");
        return false;
    }
}
