import domain.Table;
import domain.TableRepository;
import sun.awt.image.ImageWatched;

import java.util.*;

public class TableOrderList {
    private final LinkedHashMap<Table, OrderList> tableOrderList;

    public TableOrderList() {
        List<Table> tables = TableRepository.tables();
        tableOrderList = new LinkedHashMap<>();
        for (Table table : tables) {
            tableOrderList.put(table, new OrderList());
        }
    }

    public void printTableOrderList(TableNumber tableNumber) {
        OrderList orderList = tableOrderList.get(tableNumber.getTable());
        orderList.printOrderList();
    }

    public void addTableOrder(TableNumber table, MenuNumber menu) {
        Table tableInstance = table.getTable();
        OrderList orderList = tableOrderList.get(tableInstance);
        orderList.addOrderList(menu);
        tableOrderList.put(tableInstance, orderList);
    }

    public int calculateTableSum(TableNumber table, TypeOfPayment payment) {
        OrderList orderList = tableOrderList.get(table.getTable());
        int sum = orderList.calculatePriceSum(payment);
        deleteOrderList(table);
        return sum;
    }

    public void deleteOrderList(TableNumber table) {
        tableOrderList.put(table.getTable(), new OrderList());
    }
}
