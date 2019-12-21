import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        int menuSelect = mainMenuSelecter();

        while(menuSelect != 3) {
            checkMenuSelect(menuSelect, tables);
            menuSelect = mainMenuSelecter();
        }
    }
    
    public static int mainMenuSelecter() {
        int mainNumber = InputView.inputMainNumber();
        return mainNumber;
    }

    public static void checkMenuSelect(final int mainMenu, final List<Table> tables) {
        if (mainMenu == 1) {
            orderNow(tables);
        } else if (mainMenu == 2) {
            payNow(tables);
        }
    }

    public static void orderNow(final List<Table> tables) {         //메인화면 1번인 주문등록
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int orderMenu = InputView.selectOrderMenu();
        int orderCount = InputView.selectCountMenu();
        tables.get(tableNumber).setAddMenu(orderMenu, orderCount);  //메뉴가 99개를 넘는지를 판단

        tables.get(tableNumber).isOrdered = 1;                      //테이블에 주문이 들어갔는지 확인
    }

    public static void payNow(final List<Table> tables) {           //메인화면 2번인 결제하기
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();
        OutputView.printBills(tables.get(tableNumber));

        int paymentNumber = InputView.selectPaymentNumber();
        OutputView.printTotal(tables.get(tableNumber), paymentNumber);

        tables.get(tableNumber).isOrdered = 0;                      //테이블이 결제가 되었는지 확인
    }


}
