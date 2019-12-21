import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final int ORDER = 1;
    private static final int PAYMENT = 2;
    private static final int EXIT = 3;

    private static final List<Table> tables = TableRepository.tables();
//    private static final int tableNumber = InputView.inputTableNumber();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        doMainService();
    }

    private static int doMainService() {
        OutputView.printMainUI();
        int choice = InputView.getInputOfMainUI();
        if (choice == ORDER) {
            doOrder();
            return ORDER;
        }
        if (choice == PAYMENT) {
            return PAYMENT;
        }
        return EXIT;
    }

    private static void doOrder() {
        OutputView.printTables(tables);
        Table table = TableRepository.findTableByNumber(InputView.getInputOfTableNumber());
        OutputView.printMenus(menus);
        Menu menu = MenuRepository.findMenuByNumber(InputView.getInputOfMenuNumber());
    }
}
