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
    
    public void enterOrderAt(TableNumber tableNum) {
    	tables.get(tableNum.convertNumberToIndex()).enterOrder();
    }
    
    //테스트용
    public void showTableStates() {
    	int i = 0;
    	for (Table table:tables) {
    		System.out.println("테이블 인덱스: " + i);
    		table.getOrders().showOrders();
    		i++;
    	}
    }
}
