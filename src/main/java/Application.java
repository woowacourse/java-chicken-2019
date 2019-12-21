import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    static final List<Table> tables = TableRepository.tables();

    public static void selectOne() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        for (Table table:tables){
            if (tableNumber == table.getNumber()){
                int[] order = OutputView.printMenus(menus);
                table.addOrder(order[0],order[1]);
            }
        }
    }

    public static void selectTwo() {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        for (Table table:tables){
            if (tableNumber == table.getNumber()){
                OutputView.printOrderList(table.getOrder(tableNumber),menus);
            }
        }
    }

    // TODO 구현 진행
    public static void main(String[] args) {
        int mainInput = OutputView.printMainScreen();
        while (mainInput != 3) {
            if (mainInput == 1) {
                selectOne();
                mainInput = OutputView.printMainScreen();
            }
            if (mainInput == 2) {
                selectTwo();
                mainInput = OutputView.printMainScreen();
            }
        }
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
