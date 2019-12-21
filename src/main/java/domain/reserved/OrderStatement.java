package domain.reserved;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 모든 예약을 가지고 있다.
public class OrderStatement {
    List<TableOrderStatement> tableOrderStatements = new ArrayList<>();

    public TableOrderStatement getTableOrderStatementBy(int id) {
        return tableOrderStatements.stream()
                .filter(tableOrderStatement -> tableOrderStatement.isMatch(id))
                .findFirst()
                .get();
    }

    public boolean isExistTableOrder(int tableNumber) {
        return tableOrderStatements.stream()
                .filter(tableOrderStatement -> tableOrderStatement.isMatch(tableNumber))
                .count() > 0;
    }


    public boolean isExist(int tableNumber, int menuId) {
        if(isExistTableOrder(tableNumber)) {
            return getTableOrderStatementBy(tableNumber)
                    .getOrderedMenus()
                    .isExistBy(menuId);
        }
        return false;
    }
}
