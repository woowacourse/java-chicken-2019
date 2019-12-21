package domain;

import java.util.ArrayList;
import java.util.List;

import view.InputView;
import view.OutputView;


public class OrderForm {
    private static final String FUNCTION_NAME = "주문하기";
    private static final int NOTINPUT = 0;
    private static final int MENU_NUMBER_INDEX = 0;
    private static final int MENU_QUANTITY_INDEX = 1;
    private static final int MAX_QUANTITY = 99;

    private int tableNumber;
    private int[] menu;

    public OrderForm() {
        menu = new int[2];
        this.tableNumber = 0;
        this.menu[MENU_NUMBER_INDEX] = 0;
        this.menu[MENU_QUANTITY_INDEX] = 0;

        writeForm();
        isDone();
    }

    public void writeForm() {
        this.tableNumber = selectTable();
        this.menu[MENU_NUMBER_INDEX] = selectMenu();
        this.menu[MENU_QUANTITY_INDEX] = selectMenuQuantity();


//        System.out.println(checkMenuQuantity());
    }

    public int selectTable() {
        int tableNumber;
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        do {
            tableNumber = InputView.inputTableNumber();
        } while (!checkTable(tableNumber));

        return tableNumber;
    }

    public int selectMenu() {
        int menuNumber;
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        do {
            menuNumber = InputView.inputMenuNumber();
        } while (!checkMenu(menuNumber));

        return menuNumber;
    }

    public int selectMenuQuantity() {
        int quantity;

        do {
            quantity = InputView.inputMenuQuantity();
        } while (!checkMenuQuantity(quantity));

        return quantity;
    }


    /*없는 번호 체크하는 method*/
    public boolean checkTable(int tableNumber) {
        final List<Table> tables = TableRepository.tables();

        for (Table t : tables) {
            if (t.existTableNumber(tableNumber)) {
                return true;
            }
        }

        /*없는 테이블 입력 시*/
        OutputView.printNonexistTableNumbers();         //재입력 요구 메세지

        return false;
    }

    public boolean checkMenu(int menuNumber) {
        final List<Menu> menus = MenuRepository.menus();

        for (Menu m : menus) {
            if (m.existMenuNumber(menuNumber)) {
                return true;
            }
        }

        OutputView.printNonexistMenuNumbers();         //재입력 요구 메세지

        return false;
    }

    public boolean checkMenuQuantity(int quantity) {
        final List<Order> orders = OrderList.orders();

        /*order가 여러개일 경우 quantity check*/
        for (Order o : OrderList.search(this.tableNumber, this.menu[MENU_NUMBER_INDEX])) {
            if (o.isOverQuantity(quantity)) {
                OutputView.printOverQuantity();
                return false;
            }
        }

        /*첫 주문 시 quantity 체크 */
        if (quantity <= MAX_QUANTITY){
            return true;

        }

        OutputView.printOverQuantity();

        return false;
    }

    /*form 작성 후 완료된 order 객체를 생성하고 list에 추가*/
    public void isDone() {
        if (this.tableNumber != NOTINPUT && this.menu[MENU_QUANTITY_INDEX] != NOTINPUT
                && this.menu[MENU_NUMBER_INDEX] != NOTINPUT) {
            OrderList.addOrder(new Order(this.tableNumber, this.menu[MENU_NUMBER_INDEX], this.menu[MENU_QUANTITY_INDEX]));
        }
    }

}
