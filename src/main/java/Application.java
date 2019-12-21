import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    private static final int FULL_ORDER = 0;
    public static void main(String[] args) {
    }

    public static void Order(){
        int tableNumber, menuNumber;

        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        if(tableNumber == FULL_ORDER){
            return;
        }
        Menu menu = MenuRepository.getMenuByNumber(InputView.inputMenu());
        menuNumber = InputView.inputOrderNumber();

        TableRepository.getTablebyNumber(tableNumber).addOrder(menu, menuNumber);
    }
}
