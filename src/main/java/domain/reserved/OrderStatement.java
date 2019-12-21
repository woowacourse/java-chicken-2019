package domain.reserved;

import domain.Table;
import domain.TableRepository;

import java.util.Collections;
import java.util.List;

public class OrderStatement {
    private final List<Table> tables = TableRepository.tables();

    public List<Table> getTables() {
        return Collections.unmodifiableList(tables);
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
        if (isExist(tableNumber, menu.getNumber())) {
            getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .getMenuBy(menu.getNumber())
                    .getCapacity()
                    .addCapacity(menu.getCapacity().getCapacity());
            return;
        }
        getTableOrderStatementBy(tableNumber)
                .addMenu(menu, menu.getCapacity().getCapacity());
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

    public void printTableOrderState(int tableId) {
        Table table = getTableOrderStatementBy(tableId);

    }
}
