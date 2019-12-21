import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    final static List<Table> tables = TableRepository.tables();
    final static List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        while (true) {
            OutputView.printMainScreen();
            final int mainFunction = InputView.inputFunctionNumber();
            if (mainFunction == 1) {
                order();
            }
            if (mainFunction == 2) {
                pay();
            }
            if (mainFunction == 3) {
                return;
            }
        }
    }
}
