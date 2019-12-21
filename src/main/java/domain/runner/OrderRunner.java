package domain.runner;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.table.Table;
import domain.table.TableRepository;
import domain.table.order.Basket;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderRunner extends Runner {

    public static List<Table> tables = TableRepository.tables();
    public static List<Menu> menus = MenuRepository.menus();

    public static void runOrder() {
        OutputView.printTables(tables);
        Table table = getTableByNumber();
        Basket basket = generateBasket(menus);
        addBasketToTable(table, basket);
    }

    private static Basket generateBasket(List<Menu> menus) {
        OutputView.printMenus(menus);

        Menu menu = getMenuByNumber();
        int countMenuNumber = InputView.inputCountMenuNumber();
        return new Basket(menu, countMenuNumber);
    }

    protected static Menu getMenuByNumber() {
        try {
            return MenuRepository.findByMenuNumber(InputView.inputMenuNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorRetryMessage(e);
            return getMenuByNumber();
        }
    }

    private static void addBasketToTable(Table table, Basket basket) {
        table.saveBasket(basket);
    }

}
