import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    final List<Table> tables = TableRepository.tables();
    final List<Menu> menus = MenuRepository.menus();

    public void run() {
        OutputView.printMain();
        menu(InputView.inputMainNumber());
    }

    private void menu(int selection) {
        if (selection == InputView.ORDER) {
            order();
            return;
        }

        if (selection == InputView.PAY) {
            pay();
            return;
        }

        if (selection == InputView.CLOSE)
            System.exit(0);
    }

    private void order() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber() - 1;
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber() - 1;
        int menuAmount = InputView.inputMenuAmount();
        TableRepository.order(tableNumber, menus.get(menuNumber), menuAmount);
    }

    private void pay() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputPayTableNumber() - 1;

        OutputView.printOrderMenus(tables, menus, tableNumber);
        InputView.inputPayNumber(tableNumber + 1);
        OutputView.printMoney(tables, tableNumber);
    }

    public static void main(String[] args) {
        Application app = new Application();
        while(true) {
            app.run();
            System.out.println();
        }
    }
}
