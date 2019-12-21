import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행

    private int mainFunctionNumber;

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        Application app = new Application();
        app.startApplication();
        app.finishApplication();
    }

    public void startApplication(){
        while(true){
            mainFunctionNumber = InputView.inputMainFunctionNumber();
            if(mainFunctionNumber == 3){
                return;
            }
            if(mainFunctionNumber == 1){

            }
            if(mainFunctionNumber == 2){

            }
        }
    }

    public void finishApplication(){
        OutputView.printProgramEnding();
    }
}
