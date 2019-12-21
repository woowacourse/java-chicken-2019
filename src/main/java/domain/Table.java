package domain;

import java.util.*;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> bills = new HashMap<Menu, Integer>();
    public int isOrdered = 0;

    public Table(final int number) {
        this.number = number;
    }

    public void setAddMenu(int menuNumber, int count) {     //지금 주문등록을 합쳐서 99개가 넘는지 확인함
        Menu menu = MenuRepository.selectMenu(menuNumber);
        
        if(checkTotal(count) == 1) {
            System.out.println("주문의 총 개수는 99개를 넘을 수 없습니다.");
        }
        else if(checkTotal(count) == 0) {
            addMenu(menu, count);
        }
    }

    public void addMenu(Menu menu, int count) {             //setAddMenu에서 99개가 안넘으면 추가 등록을 받을 수 있음
        if (bills.containsKey(menu)) {                      //같은 메뉴가 주문이 되어있다면 개수만 변경함
            bills.put(menu, bills.get(menu) + count);
        }
        else if (!bills.containsKey(menu)){                 //같은 메뉴가 주문이 되지 않았다면 새로 등록함
            bills.put(menu, count);
        }
    }

    public int checkTotal(int count) {                      //현재 총 주문개수를 반환하는 함수
        int total = 0;
        Iterator itr = bills.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            total += e.getValue();
        }

        if (total + count > 99) {
            return 1;
        }
        return 0;
    }
    
    public void printTableNumber() {
        System.out.println(number + "번 테이블의 결제를 진행합니다.");
    }

    public void printBill() {                               //주문한 내역을 출력하는 함수
        Iterator itr = bills.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            System.out.println(e.getKey().printMenu(e.getValue()));
        }
    }

    public int totalPay(int payment) {                                              //총 금액을 반환
        int chickenCount = 0;
        int sum = 0;
        Iterator itr = bills.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            sum += e.getKey().totalPay(e.getValue());
            chickenCount += e.getKey().isChicken() * e.getValue();                  //치킨 메뉴가 주문되었다면 마릿수를 계산함
        }
        if(chickenCount >= 10) {                                                    //치킨 10마리당 10000원 할인
            sum -= chickenCount / 10 * 10000;
        }
        if(payment == 2) {                                                          //현금 결제시 5% 할인
            return (int)((double)sum * 0.95);
        }
        return sum;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
