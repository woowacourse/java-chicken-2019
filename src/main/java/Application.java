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

    static int actionNumber = 0;
    static int payMethod = 0;
    static double totalPay = 0;
    static int nowTableNumber = -1;

    final static List<Table> tables = TableRepository.tables();
    final static List<Menu> menus = MenuRepository.menus();

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
    public static void getTableIndex(int tableNumber){
        for (int i = 0; i < tables.size(); i++) {
            if(tables.get(i).isEqaulTableNumber(tableNumber)){
                nowTableNumber = i;
                break;
            }
        }
    }
    public static void chooseAction(int actionNumber){
        if(actionNumber == ORDER_KEY) {
            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();
            getTableIndex(tableNumber);

            tables.get(nowTableNumber).checkNewOrder();
            OutputView.printMenus(menus);
            final int menuCategory = InputView.inputMenuCategory();
            final int menuCount = InputView.inputMenuCount();
            System.out.println(tables.get(nowTableNumber).order(menuCategory,menuCount));
            tables.get(nowTableNumber).printNowOrder();
        }
        if(actionNumber == PAY_KEY){
            payMethod = InputView.inputPayMethod();
            totalPay = Pay.CashOrCredit(payMethod);
            System.out.printf("결제금액 : %f \n",totalPay);
        }
    }
}
