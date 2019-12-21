package domain.reserved;

import domain.Table;
import domain.TableRepository;

import java.util.List;

// 모든 예약을 가지고 있다.
public class OrderStatement {
    private final List<Table> tables = TableRepository.tables();

    public List<Table> getTables() {
        return tables;
    }

    public Table getTableOrderStatementBy(int id) {
        return tables.stream()
                .filter(table -> table.isMatch(id))
                .findFirst()
                .get();
    }

    public boolean isExist(int tableNumber, int menuId) {
        if (contain(tableNumber)) {
            return getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .isExistBy(menuId);
        }
        return false;
    }

    public void addTableOrderStatement(int tableNumber, OrderedMenu menu) {
        Table table;
        if (!contain(tableNumber)) {
            table = new Table(tableNumber);
            table.addMenu(menu);
            return;
        }
        getTableOrderStatementBy(tableNumber).addMenu(menu);
    }

    private boolean contain(int tableIndex) {
        return tables.stream()
                .anyMatch(table -> table.isMatch(tableIndex));
    }

    public int checkExistTable(int tableId) {
        if (!contain(tableId)) {
            throw new IllegalArgumentException();
        }
        return tableId;
    }
}
