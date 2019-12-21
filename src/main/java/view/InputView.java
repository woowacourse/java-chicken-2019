package view;

import domain.MenuRepository;
import domain.TableRepository;
import domain.Menu;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_ORDER = 99;
    private static final int EXIT = 0;

    public static int inputAction(){
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료\n");

        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        int tableNumber;

        System.out.println("## 주문할 테이블을 선택하세요.");
        tableNumber = scanner.nextInt();
        if(!TableRepository.contains(tableNumber)){
            tableNumber = inputTableNumber();
        }else if(TableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                >= MAX_ORDER){
            System.out.println("더 이상 주문할 수 없습니다.");
            return EXIT;
        }

        return tableNumber;
    }

    public static int inputMenu(){
        int menu;

        System.out.println("## 등록할 메뉴를 선택하세요.");
        menu = scanner.nextInt();
        if(!MenuRepository.contains(menu)){
            menu = inputMenu();
        }

        return menu;
    }

    public static int inputOrderNumber(){
        int order;

        System.out.println("## 메뉴의 수량을 입력하세요. (99개 이하 입력 가능)");
        order = scanner.nextInt();

        if(order > 99){
            order = inputOrderNumber();
        }

        return order;

    }
}
