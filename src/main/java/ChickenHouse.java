import java.util.List;

import domain.Cashier;
import domain.Menu;
import domain.MenuRepository;
import domain.Restaurant;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenHouse {
    private Restaurant restaurant = new Restaurant();

    public void start() {
        int selectedFeature = InputView.inputMain();
        if (selectedFeature == 3) {
            return;
        }
        progress(selectedFeature, selectTable());
    }

    private int selectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    private void progress(int selectedFeature, int tableNumber) {
        if (selectedFeature == 1) {
            order(tableNumber);
        }
        if (selectedFeature == 2) {
            pay(tableNumber);
        }
    }

    private void order(int tableNumber) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int menuQuantity = InputView.inputMenuQuantity();
        restaurant.orderMenu(TableRepository.findByNumber(tableNumber), menuNumber, menuQuantity);
        System.out.println(restaurant);
        start();
    }

    private void pay(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        Cashier cashier = new Cashier(restaurant.getOrder(table));
        OutputView.printOrders(tableNumber);
        int payMethod = InputView.inputPayMethod(tableNumber);
        int total = 0;
        if (payMethod == 1) {
            total = cashier.discountByChickenQuantity().getAmount();
        }
        if (payMethod == 2) {
            total = cashier.discountByCash().getAmount();
        }
        System.out.println(total + "원");
        restaurant.clearTable(table);
        start();
    }
}
