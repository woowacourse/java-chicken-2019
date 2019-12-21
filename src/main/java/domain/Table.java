package domain;

import Constant.ConstantNumber;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private static int numberOfChicken;
    private static int totalPrice;
    private List<Menu> menus = new ArrayList<>();
    private List<Integer> orders = new ArrayList<>();

    public Table(final int number) {
        this.number = number;
    }

    public void clearTable(){
        menus.clear();
        orders.clear();
        numberOfChicken = 0;
        totalPrice = 0;
    }

    public int getOrderedMenuNumber(){
        int total_Order = 0;
        for(int i = 0; i < orders.size(); i++){
            total_Order += orders.get(i);
        }
        return total_Order;
    }

    public int availableOrderNumber(){
        return ConstantNumber.MAX_ORDER - getOrderedMenuNumber();
    }

    public int getTableNumber(){
        return this.number;
    }

    public void addOrder(Menu menu, int order){
        if(menus.contains(menu)){
            int index = menus.indexOf(menu);
            orders.set(index, orders.get(index) + order);
            return;
        }
        menus.add(menu);
        orders.add(order);
    }

    public void printOrders(){
        for(int i = 0; i < menus.size(); i++){
            System.out.printf("%s %d %d",
                    menus.get(i).getName(),
                    orders.get(i),
                    (int)menus.get(i).getPrice() * orders.get(i));
        }
    }

    public double getTotalPrice(){
        for(int i = 0; i < menus.size(); i++){
            totalPrice += menus.get(i).getPrice() * orders.get(i);
        }
        return totalPrice;
    }

    public int getTotalChicken(){
        for(int i = 0; i < menus.size(); i++){
            if(menus.get(i).isChicken()){
                numberOfChicken += orders.get(i);
            }
        }
        return numberOfChicken;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
