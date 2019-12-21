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
    private static final int DISCOUNT_UNIT = 10000;
    private static final int DISCOUNT_AMOUNT = 10;
    private static final int NONE_MENU_AMOUNT = 0;
    private static final int MONEY = 2;
    private static final int RESERVED = 1;
    private static final int OFFSET = 0;
    private static final int MAXIMUM_MENU_QUANTITY = 99;
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
        int orderState = InputView.inputOrderNumber();
        if(orderState == REGIST_MENU){
            orderMenu(tables);
            return true;
        }
        if(orderState == MAKE_PAYMENT){
            calculatePayMent(reservedTable,orderMenuInTable,tables, menus);
            return true;
        }
        return false;
    }

    private static void calculatePayMent(HashMap<Integer, Integer> reservedTable,int[][] orderMenuInTable,
                                         List<Table> tables, List<Menu> menus) {
        if(reservedTable.isEmpty()) {
            System.out.println("결제할 테이블이 없습니다");
            return;
        }
        OutputView.printOrderTable(reservedTable,tables);
        int paymentTable = InputView.inputTableNumber(tables);
        isWrongTable(reservedTable, paymentTable);
        int allPayment = paymentOrderMenu(orderMenuInTable,paymentTable,menus);
        checkDiscount(allPayment, orderMenuInTable, paymentTable);


    }

    private static void checkDiscount(int allPayment,int[][] orderMenuInTable, int paymentTable) {
        if(InputView.inputPaymentMethod() == MONEY) {
            OutputView.moneyPayment(allPayment);
            return;
        }
        OutputView.cardPayMent(allPayment);
        removeTable(orderMenuInTable, paymentTable);
    }

    private static void removeTable(int[][] orderMenuInTable, int paymentTable) {
        for(int removeMenuNumber = OFFSET; removeMenuNumber < orderMenuInTable[paymentTable][removeMenuNumber]; removeMenuNumber++) {
            orderMenuInTable[paymentTable][removeMenuNumber] = NONE_MENU_AMOUNT;
        }
        reservedTable.remove(paymentTable);
    }

    private static int paymentOrderMenu(int[][] orderMenuInTable, int paymentTable, List<Menu> menus) {
        int allPayment = OFFSET;
        for(int orderTableMenu = OFFSET; orderTableMenu < orderMenuInTable[paymentTable].length; orderTableMenu++) {
            if(orderMenuInTable[paymentTable][orderTableMenu] != NONE_MENU_AMOUNT) {
                allPayment += orderPrice(orderMenuInTable[paymentTable][orderTableMenu],orderTableMenu, menus);
            }
        }
        return allPayment;
    }

    private static int orderPrice(int menuCount, int orderTableMenu, List<Menu> menus) {
        System.out.println("##주문내역");
        System.out.println("메뉴 수량 금액");
        for(Menu menu : menus) {
            if(menu.getNumber() == orderTableMenu){
                OutputView.eachPayment(menu, menuCount);
                return menu.getPrice() * menuCount - paymentDiscount(menuCount);
            }
        }
        return NONE_PRICE;
    }

    private static int paymentDiscount(int menuCount) {
        return menuCount / DISCOUNT_AMOUNT * DISCOUNT_UNIT;

    }

    private static void isWrongTable(HashMap<Integer, Integer> reservedTable, int paymentTable) {
        if(!reservedTable.containsKey(paymentTable)) {
            System.out.println("잘못된 테이블 입니다.");
        }
    }

    private static void orderMenu(List<Table> tables) {
        OutputView.printOrderTable(reservedTable,tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        final int menuNumer = InputView.inputMenuNumber(menus);
        final int menuCountNumber = InputView.inputChooseMenuAmount();
        registOrder(tableNumber, menuNumer, menuCountNumber);
        OutputView.printOrderTable(reservedTable,tables);
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
