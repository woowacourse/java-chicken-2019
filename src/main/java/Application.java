import domain.Menu;
import domain.MenuRepository;
import domain.OrderBoard;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OrderBoard orderBoard = new OrderBoard();

        OutputView.printMainScreen();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber(tables);

        final List<Menu> menus = MenuRepository.menus();
        orderBoard.add(tableNumber,OutputView.printMenus(menus));
    }
}
