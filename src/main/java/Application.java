import com.sun.tools.internal.ws.wsdl.document.Output;
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

        while(true) {
            OutputView.printMain();
            final int mainDecision = InputView.inputMain();
            if (mainDecision == 1) {
                order(tables, menus);
                continue;
            }
            if (mainDecision == 2) {
                continue;
            }
            if (mainDecision == 3) {
                OutputView.printTerminatingProgram();
                return;
            }
            OutputView.printInvalidMainInput();
            continue;
        }
    }

    public static void order(List tables, List menus) {
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumberForOrder();
        OutputView.printMenus(menus);
        final int menuNumber = InputView.inputMenuNumber();
        final int menuQuantity = InputView.inputMenuQuantity();
    }
}
