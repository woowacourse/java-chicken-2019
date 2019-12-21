import java.util.List;

import domain.*;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        final List<Menu> menus = MenuRepository.menus();

        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        MenuService menuService = new MenuServiceImpl(menus, outputView);

        TableService tableService = new TableServiceImpl(tables, menuService, inputView, outputView);
        PoS pos = new ChichenPoS(tableService, inputView, outputView);

        pos.handle();
    }
}
