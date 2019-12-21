import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    static final int REGISTER_ORDER = 1;
    static final int PAYMENT = 2;
    static final int EXIT_PROGRAM = 3;
    static final int MAX_MENU_COUNT = 99;
    static final int MIN_MENU_COUNT = 0;
    static final int CASH_PAYMENT = 2;
    static final int CHICKEN_MENU_SUM = 10;
    static final int DISCOUNT_MONEY = 10000;
    static final double DISCOUNT_PERCENTAGE = 0.95;


    public static int calcPayment(int tableNumber, int paymentNumber){
        int total = 0;
        Table table = TableRepository.getSelectTable(tableNumber);
        List<Menu> menuList = table.getMenuList();
        for(int i = 0 ; i < menuList.size() ; i++){
            total += menuList.get(i).getPrice();
        }
        int chickenCount = table.getCategoryIsChickenCount();
        if(chickenCount > CHICKEN_MENU_SUM){
            total -= ((chickenCount / CHICKEN_MENU_SUM) * DISCOUNT_MONEY);
        }
        if(paymentNumber == CASH_PAYMENT){
            total = (int) (total * DISCOUNT_PERCENTAGE);
        }
        return total;
    }

    public static int checkTableNumber(int tableNumber){
        while(!TableRepository.existTableNumber(tableNumber)){
            tableNumber = InputView.inputTableNumberErr();
        }
        return tableNumber;
    }

    public static int checkMenuNumber(int menuNumber){
        while(!MenuRepository.existMenuNumber(menuNumber)){
            menuNumber = InputView.inputMenuNumberErr();
        }
        return menuNumber;
    }

    public static int checkMenuCount(int menuCount){
        while(true){
            if(menuCount <= MIN_MENU_COUNT || menuCount > MAX_MENU_COUNT){
                menuCount = InputView.inputMenuCountErr();
                continue;
            }
            break;
        }
        return menuCount;
    }

    public static void addMenuToTable(int menuCount, int tableNumber, int menuNumber){
        for(int i = 0 ; i < menuCount ; i++){
            TableRepository.getSelectTable(tableNumber).addMenu(MenuRepository.getMenu(menuNumber));
        }
    }

    public static int checkPayment(int paymentNumber){
        while(true){
            if(paymentNumber <= 0 || paymentNumber > 2){
                paymentNumber = InputView.inputPaymentNumberErr();
                continue;
            }
            break;
        }
        return paymentNumber;
    }

    public static int isPayPossibleTable(int tableNumber){
        while(!OutputView.checkOrder[TableRepository.getTableListIndex(tableNumber)]){
            tableNumber = InputView.inputPaymentTableNumberErr();
        }
        return tableNumber;
    }

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.checkOrder = new boolean[TableRepository.getTablesSize()];
        TableRepository.addMenuListToAllTables();;

        while(true){
            OutputView.printMain();
            int funcNumber = InputView.inputFuncNumber();
            if(funcNumber == EXIT_PROGRAM){
                OutputView.printExitProgram();
                break;
            }

            if(funcNumber == REGISTER_ORDER){
                OutputView.printTables(tables);
                int tableNumber = InputView.inputTableNumber();
                tableNumber = checkTableNumber(tableNumber);
                OutputView.printMenus(menus);
                int menuNumber = InputView.inputMenuNumber();
                menuNumber = checkMenuNumber(menuNumber);
                int menuCount = InputView.inputMenuCount();
                menuCount = checkMenuCount(menuCount);
                addMenuToTable(menuCount, tableNumber, menuNumber);
                OutputView.checkOrder[TableRepository.getTableListIndex(tableNumber)] = true;
            }

            if(funcNumber == PAYMENT){
                OutputView.printTables(tables);
                int tableNumber = InputView.inputTableNumber();
                tableNumber = isPayPossibleTable(tableNumber);
                OutputView.printOrderHistory(tableNumber);
                OutputView.printPayment(tableNumber);
                int paymentNumber = InputView.inputPaymentNumber();
                paymentNumber = checkPayment(paymentNumber);
                int totalPayment = calcPayment(tableNumber, paymentNumber);
                OutputView.printTotalPayment(totalPayment);
                OutputView.checkOrder[TableRepository.getTableListIndex(tableNumber)] = false;
                TableRepository.getSelectTable(tableNumber).deleteMenuList();
            }

        }
    }
}
