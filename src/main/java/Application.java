import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        while(true){
            OutputView.printMain();
            int chooseNumber = InputView.inputChooseFunc();

            if(chooseNumber == 3){
                OutputView.printExitProgram();
                break;
            }



            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();


        }

        OutputView.printMenus(menus);
    }
}
