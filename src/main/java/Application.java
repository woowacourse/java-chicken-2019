import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    static final List<Table> tables = TableRepository.tables();
    static final List<Menu> menus = MenuRepository.menus();

    public static void main(String[] args) {
        Application application = new Application();
        application.mainMenu();
    }

    private void processOrder() {
        int tableNumber = tableMenu(tables);
        Table orderTable = TableRepository.selectTable(tableNumber);
        int menuNumber = menuMenu(menus);
        int quantityNumber = quantityMenu();
        orderTable.addOrderMenu(menuNumber, quantityNumber);
        mainMenu();
    }

    private void processPayment() {
        int tableNumber = tableMenu(tables);
        Table orderTable = TableRepository.selectTable(tableNumber);
        if (orderTable.getOrderTF()) {
            processPaymentContinue(orderTable, tableNumber);
            return;
        }
        proccessPaymentCancel(tableNumber);
        return;
    }

    private void processPaymentContinue(Table orderTable, int tableNumber) {
        OutputView.printOrderHistory(orderTable);
        int paymentType = paymentTypeMenu(tableNumber);
        OutputView.printTotalOrder(tableNumber, paymentType);
        orderTable.clearOrderMenu();
        mainMenu();
    }

    private void proccessPaymentCancel(int tableNumber) {
        OutputView.printTableNoOrder(tableNumber);
        mainMenu();
    }

    private void processEnd() {
        System.out.println("\n## POS 프로그램을 종료합니다.");
        System.exit(0);
    }

    private void mainMenu() {
        OutputView.printMainMenu();
        int mainMenuNumber = InputView.inputMainMenuNumber();
        if (mainMenuNumber == 1) {
            processOrder();
            return;
        } else if (mainMenuNumber == 2) {
            processPayment();
            return;
        }
        processEnd();
    }

    private int tableMenu(List<Table> tables) {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        return tableNumber;
    }

    private int menuMenu(List<Menu> menus) {
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        return menuNumber;
    }

    private int quantityMenu() {
        int quantityNumber = InputView.inputQuantityNumber();
        return quantityNumber;
    }

    private int paymentTypeMenu(int tableNumber) {
        int paymentNumber = InputView.inputPaymentTypeNumber(tableNumber);
        return paymentNumber;
    }
}
