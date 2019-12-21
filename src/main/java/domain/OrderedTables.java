package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderedTables {
    private List<Table> orderedTables = new ArrayList<>();

    public void addTable(Table inputTable) {
        orderedTables.add(inputTable);
    }

}
