import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static int ORDER = 1;
    public static int CHECKOUT = 2;
    public static int QUIT = 3;

    public static void main(String[] args) {
        TableDeck deck = new TableDeck();
        Orders orders = new Orders();
        int functionNumber = selectFunction();
        while (functionNumber != QUIT) {
            if (functionNumber == ORDER) {
                orders.add(placeOrder(deck));
            }
            if (functionNumber == CHECKOUT) {

            }
            if (functionNumber == QUIT) {
                break;
            }
            functionNumber = selectFunction();
        }

    }

    public static int selectFunction() {
        OutputView.printFunctions();
        return InputView.inputFunctionNumber();
    }

    public static Order placeOrder(TableDeck deck) {
        printFullTable(deck);
        final int tableNumber = InputView.inputTableNumber();
        deck.pop(tableNumber);
        printFullTable(deck);
        printFullMenu();
        Menus orderedMenus = new Menus(MenuRepository.getMenu(InputView.inputMenuNumber()),
                                       InputView.inputMenuQuantity());
        OutputView.printMenus(orderedMenus.getMenus());
        return new Order(new Table(tableNumber), orderedMenus);
    }

    public static void printFullTable(TableDeck deck) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables, deck);
    }

    public static void printFullMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    public static void checkout() {
    }

    public static boolean quit(int quitProgram) {
        return quitProgram == 3;
    }
}
