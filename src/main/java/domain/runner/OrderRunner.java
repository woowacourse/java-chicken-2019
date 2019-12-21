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
        Table table = inputTableInfo();
        Basket basket = generateBasket(menus);
        addBasketToTable(table, basket);
    }

    private static Basket generateBasket(List<Menu> menus) {
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int countMenuNumber = InputView.inputCountMenuNumber();

        Menu menu = MenuRepository.findByMenuNumber(menuNumber);
        return new Basket(menu, countMenuNumber);
    }

    private static void addBasketToTable(Table table, Basket basket) {
        table.saveBasket(basket);
    }

}
