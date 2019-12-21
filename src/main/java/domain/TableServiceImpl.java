package domain;


import view.InputView;
import view.OutputView;

import java.security.InvalidParameterException;
import java.util.List;

public class TableServiceImpl implements TableService {
    private List<Table> tables;
    private MenuService menuService;

    public TableServiceImpl(List<Table> tables, MenuService menuService) {
        this.tables = tables;
        this.menuService = menuService;
    }

    @Override
    public void register() {
        showTables();
        int tableNumber = InputView.inputTableNumber();
        Table table = getTableByNumber(tableNumber);

        menuService.showMenues();
        int menuNumber = InputView.inputMenuNumber();
        Menu menu = menuService.getMenuByNumber(menuNumber);

        int menuAmount = InputView.inputMenuAmount();

        for (int i = 0; i < menuAmount; i++) {
            table.takeOrder(menu);
        }

    }

    private Table getTableByNumber(int tableNumber) {

        for (Table table : tables) {
            if (table.isTarget(tableNumber)) {
                return table;
            }
        }

        throw new InvalidParameterException("테이블이 존재하지 않습니다.");
    }

    @Override
    public void showTables() {
        OutputView.printTables(tables);

    }
}
