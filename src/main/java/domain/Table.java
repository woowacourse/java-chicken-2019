package domain;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    public List<Integer> menuCategory = new ArrayList<>();
    public List<Integer> menuCount = new ArrayList<>();
    private final int MAX_ORDER_COUNT = 99;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void printNowOrder() {
        for (int i = 0; i < menuCategory.size(); i++){
            System.out.printf("메뉴 : %d , 수량 : %d \n",menuCategory.get(i),menuCount.get(i));
        }
    }

    public boolean isEqaulTableNumber(int tableNumber) {
        return number == tableNumber;
    }

    public void checkNewOrder() {
        System.out.printf("%d 테이블에 주문 연결이 되는지 확인 \n", number);
    }

    public String order(int newMenuCategory, int newMenuCount){
        if(isNotFirstMenuCategory(newMenuCategory)){
            inputOrder(newMenuCategory,newMenuCount);
            return "추가 주문이 완료되었습니다.";
        }
        inputNewOrder(newMenuCategory,newMenuCount);
        return "새로운 주문이 완료되었습니다.";
    }

    public void inputNewOrder(int newMenuCategory, int newMenuCount){
        menuCategory.add(newMenuCategory);
        menuCount.add(newMenuCount);
    }

    public void inputOrder(int newMenuCategory, int newMenuCount) {
        if(isNotOverCountNumber(newMenuCategory,newMenuCount)) {
            menuCount.set(menuCategory.indexOf(newMenuCategory), calculateCount(newMenuCategory, newMenuCount));
        }
    }

    public boolean isNotFirstMenuCategory(int newMenuCategory) {
        return menuCategory.contains(newMenuCategory);
    }

    public int calculateCount(int newInputMenuCategory, int newInputMenuCount) {
        return menuCount.get(menuCategory.indexOf(newInputMenuCategory)) + newInputMenuCount;
    }

    public boolean isNotOverCountNumber(int newInputMenuCategory, int newInputMenuCount) {
        return calculateCount(newInputMenuCategory, newInputMenuCount) < MAX_ORDER_COUNT;
    }

}
