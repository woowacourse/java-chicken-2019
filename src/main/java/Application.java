import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import javax.swing.plaf.FontUIResource;
import java.util.List;

public class Application {

    private static TableOrderList tableOrderList = new TableOrderList();
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        while(true) {
            OutputView.mainDisplay();
            FunctionNumber functionNumber =
                    new FunctionNumber(InputView.inputFunctionNumber());
            if(functionNumber.isExit()){
                OutputView.printExitProgram();
                break;
            }
            run(functionNumber, tables);

            //final List<Menu> menus = MenuRepository.menus();
            //OutputView.printMenus(menus);
        }
    }
    public static void run(FunctionNumber functionNumber, List<Table> tables){
        OutputView.printTables(tables);
        TableNumber tableNumber =
                new TableNumber(InputView.inputTableNumber());
        if(functionNumber.isRegisterOrder()){
            registerOrder(tableNumber, tables);
            return;
        }
        payment(tableNumber, tables);
    }
    public static void registerOrder(TableNumber tableNumber,
                                     List<Table> tables ){
        MenuNumber menuNumber = new MenuNumber(InputView.inputMenuNumber(),
                InputView.inputNumberOfMenu());
        tableOrderList.addTableOrder(tableNumber, menuNumber);
        tableOrderList.printTableOrderList();
    }
    public static void payment(TableNumber tableNumber,
                               List<Table> tables){

    }
}
