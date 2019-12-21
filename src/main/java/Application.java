import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import utils.SelectionHandeler;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Menu> menus = MenuRepository.menus();

        OutputView.printMainMenu();
        final int menuNumber = SelectionHandeler.selectFunction();
        if (menuNumber == 1) {
            OrderController orderController = new OrderController();
        }
        if(menuNumber == 2) {
            OutputView.printMenus(menus);
        }
    }
}
