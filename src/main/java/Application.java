import domain.Menu;
import domain.MenuRepository;
import domain.PosFunction;
import domain.Table;
import domain.TableRepository;
import java.util.Arrays;
import java.util.List;
import view.IllegalUserInputException;
import view.InputView;
import view.OutputView;

public class Application {

    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        PosFunction posFunction;

        do {
            OutputView.printPosFunctions(Arrays.asList(PosFunction.values()));
            posFunction = PosFunction.of(InputView.inputPosFunction());

            if (posFunction == PosFunction.ORDER_REGISTRATION) {
                register_order();
            }
            if (posFunction == PosFunction.PAYMENT) {
                pay();
            }
        } while (posFunction != PosFunction.EXIT);
    }

    private static void register_order() {
        OutputView.printTables(tables);
        final Table table = readTable();

        OutputView.printMenus(menus);
        final Menu menuToRegister = readMenu();

        final int menuCount = InputView.inputMenuCount();

        table.registerMenu(menuToRegister, menuCount);
    }

    private static Table readTable() {
        return tables.stream()
            .filter(table -> table.isNumber(InputView.inputTableNumber()))
            .findFirst()
            .orElseThrow(() -> new IllegalUserInputException("존재하지 않는 테이블입니다."));
    }

    private static Menu readMenu() {
        return menus.stream()
            .filter(targetMenu -> targetMenu.isNumber(InputView.inputMenuNumber()))
            .findFirst()
            .orElseThrow(() -> new IllegalUserInputException("존재하지 않는 메뉴입니다."));
    }

    private static void pay() {

    }
}
