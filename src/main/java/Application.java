import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Action> actions = ActionRepository.actions();
        boolean roof = true;
        while (roof) {
            OutputView.printActions(actions);
            int actionNumber = selectAction();
            roof = actionQuery(actionNumber);
        }
    }
    
    /**
     * @return 프로그램을 종료할 시 false 를 반환한다.
     */
    public static boolean actionQuery(int actionNumber) {
        if (actionNumber == 1) {
            register();
            return true;
        }
        if (actionNumber == 2) {
            pay();
            return true;
        }
        if (actionNumber == 3) {
            return false;
        }

        throw new IllegalArgumentException("메인화면에서 입력은 1,2,3 중 하나여야 합니다.");
    }

    public static void register() {
        int tableNum = selectTable();
        int menuNum = selectMenu();
        int amount = selectAmount();
        Menu menu = MenuRepository.getMenuByNum(menuNum);
        Order order = new Order(menu, amount);
        TableRepository.addMenuAtTable(tableNum, order);
    }

    public static int selectAction() {
        int actionNum = InputView.inputActionNumber();
        while (!ActionRepository.isInAction(actionNum)) {
            OutputView.printActionNumWarning();
            actionNum = InputView.inputActionNumber();
        }
        return actionNum;
    }

   public static int selectTable() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int tableNum = InputView.inputTableNumber();
        while (!TableRepository.isInTable(tableNum)) {
            OutputView.printTableNumWarning();
            tableNum = InputView.inputTableNumber();
        }
        return tableNum;
    }

    public static int selectMenu() {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNum = InputView.inputMenuNumber();
        while (!MenuRepository.isInMenu(menuNum)) {
            menuNum = InputView.inputMenuNumber();
        }

        return menuNum;
    }

    public static int selectAmount() {
        int amount = InputView.inputAmount();
        while (amount > Order.MAX || amount < Order.MIN) {
            OutputView.printAmountWarning();
            amount = InputView.inputAmount();
        }
        return amount;
    }

    public static void pay() {
        int tableNum = selectTable();
        Table table = TableRepository.getTableByNum(tableNum);
        OutputView.printOrderHistory(table);
        Payment payment = new Payment(InputView.inputPayment(tableNum));
        double price = table.sum(payment.isCash());
        OutputView.printResult(price);
    }

}
