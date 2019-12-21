package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menuList;

    public Table(final int number) {
        this.number = number;
    }

    public void addMenuList(){
        this.menuList = new ArrayList<>();
    }

    public int getNumber(){
        return this.number;
    }

    public void addMenu(Menu menu){
        this.menuList.add(menu);
    }

    public List<Menu> getMenuList(){
        return this.menuList;
    }

    public void deleteMenuList(){
        this.menuList.clear();
    }

    public int getCategoryIsChickenCount(){
        int chickenCount = 0;
        for(int i = 0 ; i < menuList.size() ; i++){
            if(menuList.get(i).getCategory() == Category.CHICKEN){
                chickenCount++;
            }
        }
        return chickenCount;
    }

    public String getMenuHistoryStr(){
        String menuHistory = "";
        for(int i = 0 ; i  < this.menuList.size() ; i++){
            menuHistory += this.menuList.get(i).toString() + "\n";
        }
        return menuHistory;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
