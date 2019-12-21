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
        while(true) {
            OutputView.mainDisplay();
            FunctionNumber functionNumber =
                    new FunctionNumber(InputView.inputFunctionNumber());
            OutputView.printTables(tables);
            TableNumber tableNumber =
                    new TableNumber(InputView.inputTableNumber());
            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
        }
    }
}
