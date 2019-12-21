package control;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Control {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    private static List<Pay> payList = PayList.List();


    public static void payAndSelect() {
        int key = 0;
        while (key != 3) {
            OutputView.printFunction();
            key = InputView.inputFunctionNumber();
            switchFunction(key);
        }
    }

    private static void switchFunction(int key) {
        if (key == 1) {
            selectTable();
        } else if (key == 2) {
            selectPayTable();
        } else if (key == 3) {
            System.out.println("정상종료");
        } else {
            System.out.println("비정상종료(1,2,3이 아닌 다른 포맷으로 종료)");
        }
    }

    private static void selectTable() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        registMenu(tableNumber);
    }

    private static void registMenu(int tableNumber) {
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        menuNumber = convertMenuNumber(menuNumber);
        tableNumber = convertTableNumber(tableNumber);
        if (menuNumber != 100) {
            payList.get(tableNumber - 1).setMenus(menus.get(menuNumber).toString());
            payList.get(tableNumber - 1).setTablePay(menus.get(menuNumber).getPrice());
            payList.get(tableNumber - 1).plusCount(menuNumber);
        } else {
            System.out.println("주문할수 없습니다.");
        }
    }

    private static void selectPayTable() {
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();
        tableNumber = convertTableNumber(tableNumber);
        payLoad(tableNumber);
    }

    private static void payLoad(int tableNumber) {
        OutputView.printResults(payList.get(tableNumber - 1).getOrderedMenu());
        int payHow = InputView.inputPayNumber(payList.get(tableNumber - 1));
        int totalPay = discount(tableNumber, payHow);
        OutputView.printPay(totalPay);
        payList.get(tableNumber -1).resetTable();
    }

    private static int discount(int tableNumber, int payHow) {
        int totalPay = payList.get(tableNumber - 1).getTablePay();
        int totalCount = payList.get(tableNumber - 1).getCount();
        if (payHow == 2) {
            totalPay -= totalPay * 0.05;
        }
        if (totalCount / 10 > 0) {
            totalPay -= (totalCount / 10) * 10000;
        }
        return totalPay;
    }

    private static int convertMenuNumber(int menuNumber) {
        if (menuNumber < 7) {
            return menuNumber - 1;
        } else if (menuNumber > 20 && menuNumber < 23) {
            return menuNumber - 15;
        }
        return 100;
    }

    private static int convertTableNumber(int tableNumber) {
        if (tableNumber == 5) {
            return 4;
        } else if (tableNumber == 6) {
            return 5;
        } else if (tableNumber == 8) {
            return 6;
        }
        return tableNumber;
    }

}
