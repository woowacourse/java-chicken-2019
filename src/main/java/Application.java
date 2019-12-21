import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import exception.PosNumber;
import exception.TableNumber;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;

public class Application {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    private static HashMap<Integer, Integer> tableRealNumber = new HashMap<>();

    public static void main(String[] args) {
        putTableRealNumber();
        SelectPosMenu(InputView.inputPosMenu());
    }

    /*
    tableRealNumber 는 각 테이블을 연속된 숫자들로 호출하기 위해 만들었다.
    각 테이블의 번호를 연속된 숫자들로 재배치 해주는 메소드
     */
    private static void putTableRealNumber() {
        tableRealNumber.put(1,0);
        tableRealNumber.put(2,1);
        tableRealNumber.put(3,2);
        tableRealNumber.put(5,3);
        tableRealNumber.put(6,4);
        tableRealNumber.put(8,5);
    }

    private static void SelectPosMenu(int posNumber) {
        if(new PosNumber(posNumber).isOptionOne()) {
            SelectOneOption();
        }
        if(new PosNumber(posNumber).isOptionTwo()) {
            SelectTwoOption();
        }
        if(new PosNumber(posNumber).isOptionThree()) {
            SelectThreeOption();
        }
    }

    private static int selectTable() {
        OutputView.printTables(tables);
        return InputView.inputTableNumber();
    }

    private static void SelectOneOption() {
       final int tableNumber = selectTable();
       OutputView.printMenus(menus);
       final int menuNumber = InputView.inputMenuNumber();
       final int menuAmount = InputView.inputMenuAmount();
       tables.get(tableRealNumber.get(tableNumber)).addMenu(menuNumber, menuAmount);
       SelectPosMenu(InputView.inputPosMenu());
    }

    private static void SelectTwoOption() {
        final int tableNumber = selectTable();
        printBill(tableNumber);
        int cardOrMoney = InputView.inputPayment(tableNumber);
    }

    private static void SelectThreeOption() {
    }

    public static void printBill(int tableNumber) {
        System.out.println("## 주문 내역\n"
                + "메뉴 수량 금액\n"
                + tables.get(tableRealNumber.get(tableNumber)).toStringBill());
    }

}
