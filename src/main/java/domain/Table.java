package domain;

import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menuList;

    public Table(final int number) {
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void addMenu(Menu menu){
        menuList.add(menu);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
