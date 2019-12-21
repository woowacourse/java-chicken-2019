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
    private static final int FEATURE_ORDER = 1;
    private static final int FEATURE_PAY = 2;
    private static final int FEATURE_QUIT = 3;
    private static final int PAY_BY_CREDIT = 1;

    private Restaurant restaurant = new Restaurant();

    public void start() {
        int selectedFeature = InputView.inputMain();
        if (selectedFeature == FEATURE_QUIT) {
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
        if (selectedFeature == FEATURE_ORDER) {
            order(tableNumber);
        }
        if (selectedFeature == FEATURE_PAY) {
            pay(tableNumber);
        }
    }

    private void order(int tableNumber) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int menuQuantity = InputView.inputMenuQuantity();
        restaurant.orderMenu(TableRepository.findByNumber(tableNumber), menuNumber, menuQuantity);
        start();
    }

    private void pay(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        Cashier cashier = new Cashier(restaurant.getOrder(table));
        OutputView.printOrders(restaurant.getOrder(table));
        OutputView.printTotal(payBy(cashier, InputView.inputPayMethod(tableNumber)));
        restaurant.clearTable(table);
        start();
    }

    private double payBy(Cashier cashier, int payMethod) {
        if (payMethod == PAY_BY_CREDIT) {
            return cashier.discountByChickenQuantity().getAmount();
        }
        return cashier.discountByCash().getAmount();
    }
}
