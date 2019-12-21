package domain;

import Constant.ConstantNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table getTablebyNumber(int number){
        for(int i = 0; i < tables.size(); i++){
            if(tables.get(i).getTableNumber() == number){
                return tables.get(i);
            }
        }
        return null;
    }

    public static boolean contains(int number){
        for(int i = 0; i < tables.size(); i++){
            if(tables.get(i).getTableNumber() == number){
                return true;
            }
        }
        return false;
    }

    public static boolean hasTableToPay(){
        for(int i = 0; i < tables.size(); i++){
            if(tables.get(i).getOrderedMenuNumber() == ConstantNumber.ZERO){
                continue;
            }
            return true;
        }
        return false;
    }


}
