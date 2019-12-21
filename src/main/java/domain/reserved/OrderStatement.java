package domain.reserved;

import domain.Table;

import java.util.ArrayList;
import java.util.List;

// 모든 예약을 가지고 있다.
public class OrderStatement {
    List<Table> tables = new ArrayList<>();

    public Table getTableOrderStatementBy(int id) {
        return tables.stream()
                .filter(table -> table.isMatch(id))
                .findFirst()
                .get();
    }

    public boolean isExistTableOrder(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isMatch(tableNumber))
                .count() > 0;
    }


    public boolean isExist(int tableNumber, int menuId) {
        if (isExistTableOrder(tableNumber)) {
            return getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .isExistBy(menuId);
        }
        return false;
    }

    public void addTableOrderStatement(int tableNumber, OrderedMenu menu) {
        Table table;
        if (!isExistTableOrder(tableNumber)) {
            table = new Table(tableNumber);
            table.addMenu(menu);
            return;
        }

        getTableOrderStatementBy(tableNumber).addMenu(menu);
    }
}
