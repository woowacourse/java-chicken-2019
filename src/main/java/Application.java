import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static final int MAX_TABLE_SIZE = 9;
    public static final int MAX_MENU_SIZE = 23;
    public static HashMap<Integer, Integer> reservedTable = new HashMap<>();
    public static int[][] orderMenuInTable = new int[MAX_TABLE_SIZE][MAX_MENU_SIZE];

    public static void main(String[] args) {
        orderChicken();
    }

    private static void orderChicken() {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        while(operationChickenHouse(tables, menus));

    }

    private static boolean operationChickenHouse(List<Table> tables, List<Menu> menus) {
        int orderState = InputView.inputOrderNumber(tables);
        if(orderState == 1){
            orderMenu(tables);
            return true;
        }
        if(orderState == 2){
            calculatePayMent(reservedTable,orderMenuInTable,tables);
            return true;
        }
        return false;
    }

    private static void calculatePayMent(HashMap<Integer, Integer> reservedTable,int[][] orderMenuInTable, List<Table> tables) {
        if(reservedTable.isEmpty()) {
            System.out.println("결제할 테이블이 없습니다");
            return;
        }
        OutputView.printOrderTable(reservedTable,tables);
        int paymentTable = InputView.inputTableNumber(tables);
        isWrongTable(reservedTable, paymentTable);


    }


    private static void isWrongTable(HashMap<Integer, Integer> reservedTable, int paymentTable) {
        if(!reservedTable.containsKey(paymentTable)) {
            System.out.println("잘못된 테이블 입니다.");
        }
    }

    private static void orderMenu(List<Table> tables) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumer = InputView.inputMenuNumber(menus);
        final int menuCountNumber = InputView.inputChooseMenuCount();
        registOrder(tableNumber, menuNumer, menuCountNumber);
        OutputView.printOrderTable(reservedTable,tables);

    }

    private static void registOrder(int tableNumber, int menuNumber, int menuCountNumber) {
        if(!reservedTable.containsKey(tableNumber)) {
            reservedTable.put(tableNumber,1);
        }
        orderMenuInTable[tableNumber][menuNumber] = menuCountNumber;
    }
}
