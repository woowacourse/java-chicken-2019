import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // TODO 구현 진행
    private static int ORDER_KEY = 1;
    private static int PAY_KEY = 2;
    private static int QUIT_KEY = 3;
    List<Order> tableList = new ArrayList<>();
    List<Order> menuList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();
    static int actionNumber = 0;
    static int payMethod = 0;
    static double totalPay = 0;
    public static void main(String[] args) {

        while(true){
            OutputView.printAction();
            actionNumber = InputView.inputActionNumber();
            chooseAction(actionNumber);
            if(actionNumber == QUIT_KEY){
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void chooseAction(int actionNumber){
        if(actionNumber == ORDER_KEY) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();

            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);
            final int menuCategory = InputView.inputMenuCategory();
            final int menuCount = InputView.inputMenuCount();

            orderList.add(new Order(tableNumber, menuCategory, menuCount));
            for (Order dd : orderList) {
                System.out.printf("테이블 : %d 메뉴 : %d 수량 : %d \n", dd.tableNumber, dd.menuCategory, dd.menuCount);
            }
        }
        if(actionNumber == PAY_KEY){
            payMethod = InputView.inputPayMethod();
            totalPay = Pay.CashOrCredit(payMethod);
            System.out.printf("결제금액 : %f \n",totalPay);
        }
    }
}
