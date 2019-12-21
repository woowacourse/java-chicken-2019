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
    private static final int ORDER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 0;
    public static void main(String[] args) {
        InputView.inputAction();
        order();
        pay();
    }

    public static void order(){
        int tableNumber, menuNumber;

        OutputView.printTables(tables);
        tableNumber = InputView.inputTableNumber();
        if(tableNumber == FULL_ORDER){
            return;
        }
        OutputView.printMenus(menus);
        Menu menu = MenuRepository.getMenuByNumber(InputView.inputMenu());
        menuNumber = InputView.inputOrderNumber();

        TableRepository.getTablebyNumber(tableNumber).addOrder(menu, menuNumber);
    }

    public static void pay(){
        int tableNumber;
        OutputView.printTables(tables);
        if(!TableRepository.hasTableToPay()){
            return;
        }
        tableNumber = InputView.inputTableNumber_Pay();
        OutputView.printOrders(TableRepository.getTablebyNumber(tableNumber));
    }
}
