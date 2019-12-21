package view;

import Constant.ConstantNumber;
import domain.MenuRepository;
import domain.TableRepository;
import domain.Table;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAction(){
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");

        System.out.println("## 원하는 기능을 선택하세요.");
        int Action = scanner.nextInt();
        if(Action < 1 || Action > 3){
            System.out.println("## 숫자 1,2,3 중에 하나를 선택하세요. \n");
            Action = inputAction();
        }

        return Action;
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        int tableNumber = scanner.nextInt();
        if(!TableRepository.contains(tableNumber)){
            System.out.println("존재하지 않는 테이블 번호입니다. \n");
            tableNumber = inputTableNumber();
        }else if(TableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                >= ConstantNumber.MAX_ORDER){
            System.out.println("더 이상 주문할 수 없습니다.");
            return ConstantNumber.CANNOT_ORDER;
        }

        return tableNumber;
    }

    public static int inputTableNumber_Pay(){
        System.out.println("## 테이블을 선택하세요.");
        int tableNumber = scanner.nextInt();
        if(!TableRepository.contains(tableNumber)){
            System.out.println("존재하지 않는 테이블 번호입니다. \n");
            tableNumber = inputTableNumber_Pay();
        }else if(TableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                == ConstantNumber.ZERO){
            System.out.println("결제 가능한 테이블이 아닙니다.\n");
            tableNumber = inputTableNumber_Pay();
        }

        return tableNumber;
    }

    public static int inputMenu(){
        int menu;

        System.out.println("## 등록할 메뉴를 선택하세요.");
        menu = scanner.nextInt();
        if(!MenuRepository.contains(menu)) {
            System.out.println("존재하지 않는 메뉴입니다. \n");
            menu = inputMenu();
        }

        return menu;
    }

    public static int inputOrderNumber(Table table){
        int order;

        System.out.printf("## 메뉴의 수량을 입력하세요. (%d개 이하 입력 가능)\n", table.availableOrderNumber());
        order = scanner.nextInt();

        if(order > table.availableOrderNumber()){
            System.out.println("주문 가능한 최대량을 초과했습니다. \n");
            order = inputOrderNumber(table);
        }

        return order;

    }

    public static int inputHowToPay(){
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int Card_or_Cash = scanner.nextInt();
        if(Card_or_Cash <= 0 || Card_or_Cash > 2){
            Card_or_Cash = inputHowToPay();
        }

        return Card_or_Cash;
    }
}
