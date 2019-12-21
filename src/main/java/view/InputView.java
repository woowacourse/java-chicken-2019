package view;

import domain.TableRepository;

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

    public static int inputTableNumber(TableRepository tableRepository) {
        int tableNumber;

        System.out.println("## 주문할 테이블을 선택하세요.");
        tableNumber = scanner.nextInt();
        if(tableRepository.getTablebyNumber(tableNumber).getOrderedMenuNumber()
                >= MAX_ORDER){
            System.out.println("더 이상 주문할 수 없습니다.");
            return EXIT;
        }
        
        return tableNumber;
    }



}
