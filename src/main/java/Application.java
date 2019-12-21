import com.sun.tools.internal.ws.wsdl.document.Output;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.*;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) throws InputMismatchException {

        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while(true) {
            OutputView.printMain();
            int mainDecision = InputView.inputMain();
            if (mainDecision == 1) {
                order(tables, menus);
                continue;
            }
            if (mainDecision == 2) {
                pay(tables);
                continue;
            }
            if (mainDecision == 3) {
                OutputView.printTerminatingProgram();
                return;
            }
            OutputView.printInvalidMainInput();
            continue;
        }
    }

    public static void order(List<Table> tables, List<Menu> menus) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumberForOrder();
        Table table = selectTableWithNumber(tables, tableNumber);
        OutputView.printMenus(menus);
        while (true) {
            int menuNumber = InputView.inputMenuNumber();
            int menuQuantity = InputView.inputMenuQuantity();
            Menu menu = orderMenuWithNumber(menus, menuNumber);
            if (table.isOrderPossible(menu, menuQuantity)) { // 주문 가능하면 break;
                table.orderMenu(menu, menuQuantity);
                break;
            }
            System.out.println("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개입니다.");
        }
    }

    public static Table selectTableWithNumber(List<Table> tables, int number) {
        Table returnTable = null;
        for (Table table: tables) {
            if (table.getNumber() == number) {
                returnTable = table;
            }
        }
        return returnTable;
    }

    public static Menu orderMenuWithNumber(List<Menu> menus, int number) {
        Menu returnMenu = null;
        for (Menu menu: menus) {
            if (menu.getNumber()==number) {
                returnMenu = menu;
            }
        }
        return returnMenu;
    }

    public static void pay(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumberForCharge();
        Table table = selectTableWithNumber(tables, tableNumber);
        OutputView.printMenusOrdered(table);
        OutputView.printPayment(table);
        int paymentMethod = InputView.inputPaymentMethod();
        OutputView.printSumOfMoneyInstruction();
        if (paymentMethod==1) {
            OutputView.printSumOfMoney(table);
            return;
        }
        if (paymentMethod==2) {
            OutputView.printSumOfMoneyCash(table);
            return;
        }
    }

}
