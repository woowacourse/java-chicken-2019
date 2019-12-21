import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Application {
    private static final int REGIST_MENU = 1;
    private static final int MAKE_PAYMENT = 2;
    private static final int NONE_PRICE = 0;
    private static final int NONE_MENU_AMOUNT = 0;
    private static final int NONE_TABLE = 0;
    private static final int MONEY = 2;
    private static final int RESERVED = 1;
    private static final int OFFSET = 0;
    private static final int MAXIMUM_MENU_QUANTITY = 99;
    private static final int MAX_TABLE_SIZE = 9;
    private static final int MAX_MENU_SIZE = 23;

    private static HashMap<Integer, Integer> reservedTable = new HashMap<>();
    private static int[][] orderMenuInTable = new int[MAX_TABLE_SIZE][MAX_MENU_SIZE];

    public static void main(String[] args) {
        orderChicken();
    }

    private static void orderChicken() {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        while(operationChickenHouse(tables, menus));
    }

    private static boolean operationChickenHouse(List<Table> tables, List<Menu> menus) {
        int orderState = InputView.inputOrderNumber();
        if(orderState == REGIST_MENU){
            orderMenu(tables);
            return true;
        }

        if(orderState == MAKE_PAYMENT){
            int paymentTable = calculatePayMent(reservedTable,tables);
            if(paymentTable == NONE_TABLE) { return true;}
            totalPayMent(menus, paymentTable);
            return true;
        }
        return false;
    }

    private static void totalPayMent(List<Menu> menus, int paymentTable) {
        int allPayment = paymentOrderMenu(orderMenuInTable, paymentTable, menus);
        checkDiscount(allPayment, orderMenuInTable, paymentTable);
    }

    private static int calculatePayMent(HashMap<Integer, Integer> reservedTable,List<Table> tables) {
        if(reservedTable.isEmpty()) {
            OutputView.nonePaymentTable();
            return NONE_PRICE;
        }
        OutputView.printTables(reservedTable, tables);
        int paymentTable = InputView.inputTableNumber(tables);
        OutputView.isWrongTable(reservedTable, paymentTable);
        return paymentTable;
    }

    private static void checkDiscount(int allPayment, int[][] orderMenuInTable, int paymentTable) {
        if(InputView.inputPaymentMethod() == MONEY) {
            OutputView.moneyPayment(allPayment);
            removeTable(orderMenuInTable, paymentTable);
            return;
        }
        OutputView.cardPayMent(allPayment);
        removeTable(orderMenuInTable, paymentTable);
    }

    private static void removeTable(int[][] orderMenuInTable, int tableNumber) {
        for(int menuNumber = OFFSET; menuNumber < orderMenuInTable[tableNumber][menuNumber]; menuNumber++) {
            orderMenuInTable[tableNumber][menuNumber] = NONE_MENU_AMOUNT;
        }

        reservedTable.remove(tableNumber);
    }

    private static int paymentOrderMenu(int[][] orderMenuInTable, int tableNumber, List<Menu> menus) {
        int allPayment = OFFSET;

        for(int orderTableMenu = OFFSET; orderTableMenu < orderMenuInTable[tableNumber].length; orderTableMenu++) {
            if(orderMenuInTable[tableNumber][orderTableMenu] != NONE_MENU_AMOUNT) {
                allPayment += orderPrice(orderMenuInTable[tableNumber][orderTableMenu],orderTableMenu, menus);
            }
        }
        return allPayment;
    }

    private static int orderPrice(int menuCount, int orderTableMenu, List<Menu> menus) {
        OutputView.orderMenu();
        for(Menu menu : menus) {
            if(menu.getNumber() == orderTableMenu){
                OutputView.eachPayment(menu, menuCount);
                return menu.getPrice() * menuCount - OutputView.paymentDiscount(menu, menuCount);
            }
        }
        return NONE_PRICE;
    }

    private static void orderMenu(List<Table> tables) {
        OutputView.printTables(reservedTable,tables);

        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumer = InputView.inputMenuNumber(menus);
        final int menuCountNumber = InputView.inputChooseMenuAmount();
        registOrder(tableNumber, menuNumer, menuCountNumber);
        OutputView.printTables(reservedTable,tables);
    }

    private static void registOrder(int tableNumber, int menuNumber, int menuAount) {
        if(!reservedTable.containsKey(tableNumber)) {
            reservedTable.put(tableNumber,RESERVED);
        }

        if(orderMenuInTable[tableNumber][menuNumber] + menuAount > MAXIMUM_MENU_QUANTITY) {
            System.out.println("수량(99개)를 초과하였습니다.");
            return;
        }
        orderMenuInTable[tableNumber][menuNumber] += menuAount;
    }
}
