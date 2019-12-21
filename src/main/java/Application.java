import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Application {

    public static HashMap<Integer, Integer> alreadyOrder = new HashMap<>();
    // TODO 구현 진행
    public static void main(String[] args) {
        orderChicken();
    }

    private static void orderChicken() {
        final List<Table> tables = TableRepository.tables();
        int orderState = InputView.inputOrderNumber(alreadyOrder, tables);
        while(operationChickenHouse(orderState, tables));

    }

    private static boolean operationChickenHouse(int orderState, List<Table> tables) {
        if(orderState == 1){
            orderMenu(tables);
            return true;
        }
        if(orderState == 2){

            return true;
        }
        return false;
    }

    private static void orderMenu(List<Table> tables) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

    }
}
