import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Tables tables = new Tables(TableRepository.tables());
        Menus menus = new Menus(MenuRepository.menus());

        InputView.inputMainMenu();
        OutputView.printTables(tables.getTables());

        int inputTableNumber = InputView.inputTableNumber(tables);
//            OutputView.printMenus(menus.getMenus());
//            if(menus.isMenuExist(InputView.inputMenuNumber())){
//                System.out.println("GOOD");
//            }
//        }
    }
}
