package domain;

import java.util.*;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> bills = new HashMap<Menu, Integer>();
    public int isOrdered = 0;

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(int menuNumber, int count) {
        Menu menu = MenuRepository.selectMenu(menuNumber);
        if (bills.containsKey(menu)) {
            bills.put(menu, bills.get(menu) + count);
        }
        else if (!bills.containsKey(menu)){
            bills.put(menu, count);
        }
    }

    public void printBill() {
        Iterator itr = bills.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            System.out.println(e.getKey().printMenu(e.getValue()));
        }
    }

    public void printTableNumber() {
        System.out.println(number + "번 테이블의 결제를 진행합니다.");
    }

    public int totalPay(int payment) {
        int chickenCount = 0;
        int sum = 0;
        Iterator itr = bills.entrySet().iterator();

        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            sum += e.getKey().totalPay(e.getValue());
            chickenCount += e.getKey().isChicken() * e.getValue();
        }
        if(chickenCount >= 10) {
            sum -= chickenCount / 10 * 10000;
        }
        if(payment == 2) {
            return (int)((double)sum * 0.95);
        }
        return sum;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
