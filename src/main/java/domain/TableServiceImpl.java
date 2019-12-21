package domain;

import java.util.List;
import java.util.Map;
import java.security.InvalidParameterException;

import view.InputView;
import view.OutputView;

public class TableServiceImpl implements TableService {
    private List<Table> tables;
    private MenuService menuService;
    private InputView inputView;
    private OutputView outputView;


    public TableServiceImpl(List<Table> tables, MenuService menuService, InputView inputView, OutputView outputView) {
        this.tables = tables;
        this.menuService = menuService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void register() {
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        Table table = getTableByNumber(tableNumber);

        menuService.showMenues();
        int menuNumber = inputView.inputMenuNumber();
        Menu menu = menuService.getMenuByNumber(menuNumber);

        int menuAmount = inputView.inputMenuAmount();

        if (MenuConfig.MENU_LIMIT_NUM < table.calculateMenuSize() + menuAmount) {
            outputView.printRessonOfOrder(MenuConfig.MENU_LIMIT_NUM);
            register();
            return;
        }

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
    public void pay() {
        outputView.printTables(tables);

        int tableNumber = inputView.inputTableNumber();
        Table table = getTableByNumber(tableNumber);
        showOrderHistory(table.getMenus());
        outputView.printGuideForPayment(table.getNumber());
        int way = inputView.inputPaymentWay();
        double moneyToPay = table.settle(way);
        table.getSettled();

        outputView.printResult(moneyToPay);
    }

    private void showOrderHistory(Map<Menu, Integer> menus) {
        outputView.printOrderHistory(menus);
    }


}
