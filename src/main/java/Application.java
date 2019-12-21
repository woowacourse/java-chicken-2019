import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private final static List<Table> tables = TableRepository.tables();
    private final static List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while (true) {
            OutputView.printMainScreen();
            final int mainFunction = InputView.inputFunctionNumber();
            if (mainFunction == 1) {
                order();
            }
            if (mainFunction == 2) {
                pay();
            }
            if (mainFunction == 3) {
                return;
            }
        }
    }

    public static void order() {
        OutputView.printTables(tables);
        final Table table = TableRepository.getTable(InputView.inputTableNumber());
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int orderAmount = InputView.inputAmount();
        table.addMenuOrder(menuNumber, orderAmount);
    }

    public static void pay() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
        final Table table = TableRepository.getTable(tableNumber);
        OutputView.printTableOrderHistory(table);
        final int paymentMethod = InputView.inputPaymentMethod(tableNumber);
        OutputView.printTablePaymentAmount(table, paymentMethod);
    }
}
