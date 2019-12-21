import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static int calcPayment(int tableNumber, int paymentNumber){
        int total = 0;
        Table table = TableRepository.getSelectTable(tableNumber);
        List<Menu> menuList = table.getMenuList();
        for(int i = 0 ; i < menuList.size() ; i++){
            total += menuList.get(i).getPrice();
        }
        int chickenCount = table.getCategoryIsChickenCount();
        if(chickenCount > 10){
            total -= ((chickenCount / 10) * 10000);
        }

        if(paymentNumber == 2){
            total = (int) (total * 0.95);
        }

        return total;
    }

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.checkOrder = new boolean[TableRepository.getTablesSize()];
        TableRepository.addMenuListToAllTables();;


        while(true){
            OutputView.printMain();
            int funcNumber = InputView.inputFuncNumber();

            if(funcNumber == 3){
                OutputView.printExitProgram();
                break;
            }

            if(funcNumber == 1){
                OutputView.printTables(tables);
                int tableNumber = InputView.inputTableNumber();
                while(!TableRepository.existTableNumber(tableNumber)){
                    tableNumber = InputView.inputTableNumberErr();
                }
                OutputView.printMenus(menus);
                int menuNumber = InputView.inputMenuNumber();

                while(!MenuRepository.existMenuNumber(menuNumber)){
                    menuNumber = InputView.inputMenuNumberErr();
                }

                int menuCount = InputView.inputMenuCount();
                while(true){
                    if(menuCount <= 0 || menuCount > 99){
                        menuCount = InputView.inputMenuCountErr();
                        continue;
                    }
                    break;
                }

                for(int i = 0 ; i < menuCount ; i++){
                    tables.get(tableNumber).addMenu(MenuRepository.getMenu(menuNumber));
                }

                OutputView.checkOrder[tableNumber] = true;
            }

            if(funcNumber == 2){
                OutputView.printTables(tables);
                int tableNumber = InputView.inputTableNumber();
                OutputView.printOrderHistory(tableNumber);
                OutputView.printPayment(tableNumber);
                int paymentNumber = InputView.inputPaymentNumber();
                int totalPayment = calcPayment(tableNumber, paymentNumber);
                OutputView.printTotalPayment(totalPayment);
            }




//            final int tableNumber = InputView.inputTableNumber();

        }
    }
}
