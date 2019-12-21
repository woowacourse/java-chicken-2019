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
    
    public static Table isExist(Table input) throws Exception {
    	if (!tables.stream()
    				.filter(table -> table.isSame(input))
    				.findFirst()
    				.isPresent()) {
    		throw new Exception("존재하지 않는 테이블입니다.");
    	}
    	
    	return tables.stream()
				.filter(table -> table.isSame(input))
				.findFirst()
				.get();
    }
}
