import domain.Menu;
import domain.MenuRepository;
import domain.OrderBoard;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    static final List<Table> tables = TableRepository.tables();
    static OrderBoard orderBoard = new OrderBoard();

    public static void selectOne(){
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber(tables);
        final List<Menu> menus = MenuRepository.menus();
        orderBoard.add(tableNumber,OutputView.printMenus(menus));
    }
    // TODO 구현 진행
    public static void main(String[] args) {
        int mainInput = OutputView.printMainScreen();
        while (mainInput != 3){
            if (mainInput == 1){
                selectOne();
                mainInput = OutputView.printMainScreen();
            }
            if (mainInput == 2){
                System.out.println("아직 만들지 않은 기능입니다.");
                mainInput = OutputView.printMainScreen();
            }
        }
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
