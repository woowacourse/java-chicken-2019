package domain;

import java.util.*;

public class Table {
    private final int number;
    private HashMap<Menu, Integer> bills = new HashMap<Menu, Integer>();

    public Table(final int number) {
        this.number = number;
    }

    public void addMenu(int menuNumber, int count) {
        Menu menu = MenuRepository.selectMenu(menuNumber);

        bills.put(menu, count);
    }

    public void printBill() {
        Iterator itr = bills.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Menu, Integer> e = (Map.Entry<Menu, Integer>)itr.next();
            System.out.println(e.getKey().printMenu(e.getValue()));
        }
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
