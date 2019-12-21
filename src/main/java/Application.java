import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        final List<Bill> bills = new ArrayList<Bill>();

        final int ORDER = 1;
        final int PAY = 2;
        final int PROGRAM_END = 3;
        int function = 0;

        do {
            OutputView.printMainScreen();
            function = InputView.inputFunctionNumber();

            if (function == ORDER) {
                Bill bill = null;
                OutputView.printTables(tables);
                final int tableNumber = InputView.inputTableNumber();
                for (Table table : tables) {
                    table.equals(tableNumber);
                    bill = new Bill(table);
                }

                OutputView.printMenus(menus);
                int menuNumber = InputView.inputMenu();
                int quantity = InputView.inputQuantity();
                for (Menu menu : menus) {
                    if(menu.equals(menuNumber)) {
                        bill.addOrder(menu, quantity);
                    }
                }
            }
        } while (function != PROGRAM_END);
    }
}
