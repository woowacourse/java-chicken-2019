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
        try {
            while (true) {
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
        } catch (InputMismatchException e) {
            OutputView.printInputMisMatchException();
        }
    }

    public static void order(List<Table> tables, List<Menu> menus) {
        Table table = tableListingAndSelectingForOrdering(tables);
        OutputView.printMenus(menus);
        while (true) {
            int menuNumber = InputView.inputMenuNumber();
            int menuQuantity = InputView.inputMenuQuantity();
            Menu menu = orderMenuWithNumber(menus, menuNumber);
            if (table.isOrderPossible(menu, menuQuantity)) {
                table.orderMenu(menu, menuQuantity);
                break;
            }
            OutputView.printQuantityLimit();
        }
    }

    public static Table tableListingAndSelectingForOrdering(List<Table> tables) {
        while (true) {
            OutputView.printTables(tables);
            int tableNumber = InputView.inputTableNumberForOrder();
            if (!isContainingSpecificTable(tables, tableNumber)) {
                OutputView.printInvalidTableNumber();
                continue;
            }
            return selectTableWithNumber(tables, tableNumber);
        }
    }

    public static boolean isContainingSpecificTable(List<Table> tables, int number) {
        boolean flag = false;
        for (Table table: tables) {
            if (table.getNumber()==number) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static Table selectTableWithNumber(List<Table> tables, int number) {
        Table returnTable = null;
        for (Table table : tables) {
            if (table.getNumber() == number) {
                returnTable = table;
            }
        }
        return returnTable;
    }

    public static Menu orderMenuWithNumber(List<Menu> menus, int number) {
        Menu returnMenu = null;
        for (Menu menu : menus) {
            if (menu.getNumber() == number) {
                returnMenu = menu;
            }
        }
        return returnMenu;
    }


    public static void pay(List<Table> tables) {
        Table table = tableListingAndSelectingForCharge(tables);
        OutputView.printMenusOrdered(table);
        table.quantityDiscount();
        OutputView.printPayment(table);
        while (true) {
            int paymentMethod = InputView.inputPaymentMethod();
            if (paymentMethod == 1) {
                OutputView.printSumOfMoneyInstruction();
                OutputView.printSumOfMoney(table);
                break;
            }
            if (paymentMethod == 2) {
                OutputView.printSumOfMoneyInstruction();
                OutputView.printSumOfMoneyCash(table);
                break;
            }
            OutputView.printInvalidPaymentMethodInput();
        }
    }

    public static Table tableListingAndSelectingForCharge(List<Table> tables) {
        while (true) {
            OutputView.printTables(tables);
            int tableNumber = InputView.inputTableNumberForCharge();
            if (!isContainingSpecificTable(tables, tableNumber)) {
                OutputView.printInvalidTableNumber();
                continue;
            }
            return selectTableWithNumber(tables, tableNumber);
        }
    }



}
