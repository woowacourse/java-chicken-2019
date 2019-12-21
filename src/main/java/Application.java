import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    final static int REGISTER_ORDER = 1;
    final static int PAYMENT = 2;
    final static int EXIT = 3;

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        run(tables, menus);
    }

    private static void run(List<Table> tables, List<Menu> menus) {
        while (true) {
            int mainMenu = InputView.inputMainMenu();
            runMenu(tables, menus, mainMenu);
        }
    }

    private static void runMenu(List<Table> tables, List<Menu> menus, int mainMenu) {
        if (isOrder(mainMenu)) {
            Order.order(tables, menus);
        }

        if (isPayment(mainMenu)) {
            Payment.payment(tables);
        }

        if (isExit(mainMenu)) {
            OutputView.printProgramExit();
        }
    }

    private static boolean isOrder(int mainMenu) {
        return mainMenu == REGISTER_ORDER;
    }

    private static boolean isPayment(int mainMenu) {
        return mainMenu == PAYMENT;
    }

    private static boolean isExit(int mainMenu) {
        return mainMenu == EXIT;
    }
}
