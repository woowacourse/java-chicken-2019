import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String REGISTER_ORDER = "주문등록";
    private static final String DO_PAYMENT= "결제하기";
    private static final String EXIT_PROGRAM = "프로그램 종료";

    private ArrayList<String> functions;

    public Application() {
        initializeFunctions();
    }

    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private void run() {
        OutputView.printMainScreen();
        OutputView.printFunctions(functions);
    }

    private void initializeFunctions() {
        functions = new ArrayList<>();
        functions.add(REGISTER_ORDER);
        functions.add(DO_PAYMENT);
        functions.add(EXIT_PROGRAM);
    }
}
