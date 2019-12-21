package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final List<Integer> nums = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    static  {
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(6);
        nums.add(8);
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void addMenuAtTable(int tableNum, Order order) {
        Table table = getTableByNum(tableNum);
        table.offer(order);
    }

    public static Table getTableByNum(int num) {
        if (num < 1 || num == 4 || num == 7 || num > 8) {
            throw new IllegalArgumentException("테이블 번호는 1,2,3,5,6,8 중 하나여야 합니다.");
        }
        if (num < 4) {
            return tables.get(num - 1);
        }
        if (num < 7) {
            return tables.get(num - 2);
        }
        return tables.get(num - 3);
    }

    public static boolean isInTable(int num) {
        return nums.contains(num);
    }
}
