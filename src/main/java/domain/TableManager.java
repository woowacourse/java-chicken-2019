package domain;

import java.util.List;

public class TableManager {
    final static List<Table> tables = TableRepository.tables();
}
