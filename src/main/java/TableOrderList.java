import domain.Table;
import domain.TableRepository;
import sun.awt.image.ImageWatched;

import java.util.*;

public class TableOrderList {
    private final LinkedHashMap<Table, OrderList> tableOrderList;

    public TableOrderList(){
        List<Table> tables = TableRepository.tables();
        tableOrderList = new LinkedHashMap<>();
        for(Table table : tables){
            tableOrderList.put(table, new OrderList());
        }
    }

    public void printTableOrderList(){
        Set<Map.Entry<Table, OrderList>> set = tableOrderList.entrySet();
        Iterator<Map.Entry<Table,OrderList>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Table,OrderList> entry = iterator.next();
            Table table = entry.getKey();
            OrderList orderList = entry.getValue();
            System.out.println(table +":");
            orderList.printOrderList();
        }
    }

    public void addTableOrder(TableNumber table, MenuNumber menu){
        Table tableInstance = table.getTable();
        OrderList orderList = tableOrderList.get(tableInstance);
        orderList.addOrderList(menu);
        tableOrderList.put(tableInstance, orderList);
    }
}
