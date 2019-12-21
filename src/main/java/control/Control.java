/*
 * Control
 *
 * ver 1.0
 *
 * 2019.12.21
 *
 * CopyRight
 *
 */
package control;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class Control {
    private static final List<Table> tables = TableRepository.tables();
    private static final List<Menu> menus = MenuRepository.menus();
    private static List<Pay> payList = PayList.List();
    /*
     * Control 클래스 입니다.
     * POS 프로그램의 메인을 담당하며 입력 및 출력을 불러와서 실행시킵니다.
     */
    public static void payAndSelect() { // 매인 파트
        int key = 0;
        while (key != 3) {
            OutputView.printFunction();
            key = InputView.inputFunctionNumber();
            switchFunction(key);
        }
    }

    private static void switchFunction(int key) { // 기능에 따라 함수를 호출 합니다.
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
        OutputView.printTables(tables, payList);
        int tableNumber = InputView.inputTableNumber();
        System.out.println(tableNumber + "a");
        registMenu(tableNumber);
    }

    private static void registMenu(int tableNumber) { // 메뉴를 등록합니다.
        System.out.println(tableNumber + "a");
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        menuNumber = convertMenuNumber(menuNumber);
        tableNumber = convertTableNumber(tableNumber);
        menuNumber = validateMenu(menus.get(menuNumber).getName(), tableNumber, menuNumber);
        if (menuNumber != 100) {
            payList.get(tableNumber - 1).setMenus(menus.get(menuNumber).getName(), menus.get(menuNumber).getPrice());
            payList.get(tableNumber - 1).setTablePay(menus.get(menuNumber).getPrice());
            payList.get(tableNumber - 1).plusCount(menuNumber);
        } else {
            System.out.println("주문할수 없습니다.(메뉴판에 없는 메뉴지정)");
        }
    }


    private static void selectPayTable() {
        OutputView.printTables(tables, payList);
        int tableNumber = InputView.inputTableNumber();
        tableNumber = convertTableNumber(tableNumber);
        System.out.println(tableNumber + "a");
        payLoad(tableNumber);
    }

    private static void payLoad(int tableNumber) { // 결제 모듈입니다.
        System.out.println(tableNumber + "a");
        OutputView.printResults(payList.get(tableNumber - 1).getOrderedMenu());
        int payHow = InputView.inputPayNumber(payList.get(tableNumber - 1));
        if (payHow == 2 || payHow == 1) {
            int totalPay = discount(tableNumber, payHow);
            OutputView.printPay(totalPay);
            payList.get(tableNumber -1).resetTable();
        } else {
            //
        }
    }

    private static int discount(int tableNumber, int payHow) { // 할인을 적용시킵니다.
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

    private static int convertMenuNumber(int menuNumber) { // 입력을 리스트 인덱스 번호에 맞게 변환시킵니다.
        if (menuNumber < 7 && menuNumber > 0) {
            return menuNumber - 1;
        } else if (menuNumber > 20 && menuNumber < 23) {
            return menuNumber - 15;
        }
        System.out.println("주문할수 없습니다.(메뉴판에 없는 메뉴지정)");
        return 100;
    }

    private static int validateMenu(String menu, int tableNumber, int menuNumber) { // 메뉴 한계치를 99로 설정합니다.
        if (payList.get(tableNumber -1).searchCount(menu) > 99) {
            System.out.println("주문할수 없습니다.(메뉴 99개 이상 주문시 주문 불가)");
            return 100;
        }
        return menuNumber;
    }

    private static int convertTableNumber(int tableNumber) { // 입력을 리스트 인덱스 번호에 맞게 변환시킵니다.
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
