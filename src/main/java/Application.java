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
        int tableNumber = tableMenu();
        Table orderTable = TableRepository.selectTable(tableNumber);
        int menuNumber = menuMenu();
        int quantityNumber = quantityMenu(orderTable, menuNumber);
        orderTable.addOrderMenu(menuNumber, quantityNumber);
        mainMenu();
    }

    private void processPayment() {
        int tableNumber = tableMenu();
        Table orderTable = TableRepository.selectTable(tableNumber);
        if (orderTable.getOrderTF()) {
            processPaymentContinue(orderTable, tableNumber);
            return;
        }
        proccessPaymentCancel(tableNumber);
    }

    private void processPaymentContinue(Table orderTable, int tableNumber) {
        OutputView.printOrderHistory(orderTable);
        int paymentType = paymentTypeMenu(tableNumber);
        OutputView.printTotalOrder(orderTable, paymentType);
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

    private int tableMenu() {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    private int menuMenu() {
        OutputView.printMenus(menus);
        return InputView.inputMenuNumber();
    }

    private int quantityMenu(Table orderTable, int menuNumber) {
        return InputView.inputQuantityNumber(orderTable, menuNumber);
    }

    private int paymentTypeMenu(int tableNumber) {
        return InputView.inputPaymentTypeNumber(tableNumber);
    }
}
