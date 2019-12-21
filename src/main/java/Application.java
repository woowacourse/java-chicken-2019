import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        Application app = new Application();
        app.startApplication();
        app.finishApplication();
    }

    public void startApplication(){
        int mainFunctionNumber;
        while(true){
            mainFunctionNumber = InputView.inputMainFunctionNumber();
            if(mainFunctionNumber == 3){
                return;
            }
            if(mainFunctionNumber == 1){
                addOrderToTable();
            }
            if(mainFunctionNumber == 2){
                paymentForTable();
            }
        }
    }

    public void addOrderToTable(){
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int amountNumber = InputView.inputAmountNumber();
        findMenuObjectAddToTableObject(menuNumber,tableNumber, amountNumber);
    }

    public void findMenuObjectAddToTableObject(int menuNumber, int tableNumber, int amountNumber){
        Table table = findTable(tableNumber);
        Menu menu = findMenu(menuNumber);
        table.addMenuToTable(menu, menuNumber, amountNumber);
    }

    public Menu findMenu(int menuNumber){
        for(Menu menu: menus){
            String menuStatus = menu.toString().split("-")[0].trim();
            if(Integer.parseInt(menuStatus) == menuNumber){
                return menu;
            }
        }
        return null;
    }

    public Table findTable(int tableNumber){
        for(Table table : tables){
            String tableStatus = table.toString().trim();
            if(Integer.parseInt(tableStatus) == tableNumber){
                return table;
            }
        }
        return null;
    }

    public void paymentForTable(){
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        Table table = findTable(tableNumber);
        int totalPrice = OutputView.printOrderHistory(table);
        int cardOrCash = InputView.inputCardOrCash(tableNumber);
        OutputView.printFinalPrice(cardOrCash, totalPrice);
    }

    public void finishApplication(){
        OutputView.printProgramEnding();
    }
}
