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

        final int ORDER = 1;
        final int PAY = 2;
        final int PROGRAM_END = 3;
        int function = 0;

        do {
            OutputView.printMainScreen();
            function = InputView.inputFunctionNumber();

            if (function == ORDER) {
                OutputView.printTables(tables);
                final int tableNumber = InputView.inputTableNumber();
                OutputView.printMenus(menus);
                int menuNumber = InputView.inputMenu();
                int quantity = InputView.inputQuantity();
            }
        } while (function != PROGRAM_END);
    }
}
