import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final int ORDER_NUMBER = 1;
    private static final int PAY_NUMBER = 2;
    private static final int END_NUMBER = 3;
    
    public static void main(String[] args) {
        start();
    }
    
    private static void start() {
        int methodNumber = InputView.inputMethodNumber();
        if (methodNumber == ORDER_NUMBER) {
            order();
            start();
        }
        if (methodNumber == PAY_NUMBER) {
            pay();
            start();
        }
        if (methodNumber == END_NUMBER) {
            return;
        }
    }
    
    private static void order() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        
        int menuNumber = InputView.inputMenuNumber();
        int menuCount = InputView.inputMenuCount();
        
        TableRepository.addMenuToTable(tableNumber, menuNumber, menuCount);
    }
    
    private static void pay() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        
        try {
            OutputView.printTableOrder(TableRepository.getTableByNumber(tableNumber));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        }
        OutputView.printTablePay(TableRepository
                .getTableByNumber(tableNumber), InputView.inputPayment());
        
    }
}
