import domain.Menu;
import domain.MenuRepository;
import domain.PosFunction;
import domain.Table;
import domain.TableRepository;
import java.util.Arrays;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

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
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }

    private static void pay() {

    }
}
