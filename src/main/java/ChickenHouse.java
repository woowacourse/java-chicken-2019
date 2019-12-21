import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class ChickenHouse {
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
        start();
    }

    private void pay(int tableNumber) {
        OutputView.printOrders(tableNumber);
        int payMethod = InputView.inputPayMethod(tableNumber);
        start();
    }
}
