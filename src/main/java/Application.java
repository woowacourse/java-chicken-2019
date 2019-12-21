import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        TableService tableService = new TableServiceImpl(tables);
        PoS pos = new ChichenPoS(tableService);

        pos.handle();


        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
