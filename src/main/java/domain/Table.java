package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menus = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() { return Integer.toString(number);
    }

    public void addMenuToTable(Menu menu, int amountNumber){
        for(int i = 0; i < amountNumber; i ++){
            menus.add(menu);
        }
    }

    public void printCurrentState(){
        for(int i = 0; i < menus.size(); i ++){
            System.out.println(menus.get(i).toString().trim());
        }
    }
}
