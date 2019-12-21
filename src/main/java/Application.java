import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();
        int inputCode = 0;
        while (inputCode != 3) {
            OutputView.printInitialMenu();
            inputCode = InputView.inputFunctionId(); // 이거에 따라서 기능 구현하는 인터페이스 만들어야 겠다.  // 주문
            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();
            TableRepository.getTableByNumber(tableNumber);
            //테이블 넘버로 테이블 가져오는 기능 구현해야한다.
            OutputView.printMenus(menus);
            int menu = InputView.inputMenuNumber();
            MenuRepository.getMenuByNumber(menu);
            int menuQuantity = InputView.inputMenuQuantity();

        }
    }
}
