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


    public TableServiceImpl(List<Table> tables, MenuService menuService, InputView inputView) {
        this.tables = tables;
        this.menuService = menuService;
        this.inputView = inputView;
    }

    @Override
    public void register() {
        Table table = inputTable();
        Menu menu = inputMenu();
        int menuAmount = inputView.inputMenuAmount();

        if (isValidAmount(table, menuAmount)) {
            OutputView.printRessonOfOrder(MenuConfig.MENU_LIMIT_NUM);
            register();
            return;
        }

        for (int i = 0; i < menuAmount; i++) {
            table.takeOrder(menu);
        }
    }

    private boolean isValidAmount(Table table, int menuAmount) {
        return MenuConfig.MENU_LIMIT_NUM < table.calculateMenuSize() + menuAmount;
    }

    private Table inputTable() {
        OutputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        return getTableByNumber(tableNumber);
    }

    private Menu inputMenu() {
        menuService.showMenues();
        int menuNumber = inputView.inputMenuNumber();
        return menuService.getMenuByNumber(menuNumber);
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
        OutputView.printTables(tables);

        int tableNumber = inputView.inputTableNumber();
        Table table = getTableByNumber(tableNumber);
        showOrderHistory(table.getMenus());
        OutputView.printGuideForPayment(table.getNumber());
        int way = inputView.inputPaymentWay();
        double moneyToPay = table.settle(way);
        table.getSettled();

        OutputView.printResult(moneyToPay);
    }

    private void showOrderHistory(Map<Menu, Integer> menus) {
        OutputView.printOrderHistory(menus);
    }


}
