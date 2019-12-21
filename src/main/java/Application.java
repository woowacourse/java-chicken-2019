import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import services.PosService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        PosService pos = new PosService();
        Boolean repeat = true;
        while(repeat.equals(true)) {
            repeat = pos.startPos();
        }















        /*
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

         */
    }
}
