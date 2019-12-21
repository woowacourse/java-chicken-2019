package domain;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;

public class OrderBoard {
    private HashMap<Integer, HashMap<Integer, Integer>> orders = new HashMap<Integer, HashMap<Integer, Integer>>();

    public void add(int tableNumber,HashMap order ){
        orders.put(tableNumber,order);
    }

    public HashMap getOrder(int tableNumber){
        return orders.get(tableNumber);
    }
}
