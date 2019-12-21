import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        OutputView.printFunctions();
        final int functionNumber = InputView.inputFunctionNumber();

        TableDeck deck = new TableDeck();

        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, deck);

        final int tableNumber = InputView.inputTableNumber();
        Table orderedTable = new Table(tableNumber);
        deck.pop(tableNumber);
        OutputView.printTables(tables, deck);

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Menus orderedMenus = InputView.inputMenus();
        OutputView.printMenus(orderedMenus.getMenus());

    }

    public static void placeOrder() {

    }

    public static void checkout() {
    }

    public static boolean quit(int quitProgram) {
        return quitProgram == 3;
    }
}
