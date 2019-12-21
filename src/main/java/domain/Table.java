package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Table {
    private final int number;
    final List<Menu> menus = MenuRepository.menus();
    //private List<Menu> order = new ArrayList<Menu>();
    private HashMap<String,Integer> orderedMenu =new HashMap<String,Integer>();
    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
    public int getNumber() {
    	return this.number;
    }
    
    public int sizess() {
    	return orderedMenu.size();
    }
    
    public boolean isOrdered() {
    	return orderedMenu.size()>0;
    }
    
    public void order(int menuType, int numberOfMenu) {
    	String menuName = "";
    	for(int i = 0;i<menus.size();i++) {
    		if(menus.get(i).getNumber()==menuType) {
    			menuName = menus.get(i).getName();
    		}
    	}
    	if(orderedMenu.containsKey(menuName)) {
    		//이미 주문한 메뉴일 경우에
    		if((numberOfMenu+orderedMenu.get(menuName))>99) {
    			System.out.println("99개 이상 주문을 불가합니다. 주문 수량이 99로 조정됩니다");
    			orderedMenu.put(menuName, 99);
    			return;
    		}
    		orderedMenu.put(menuName, numberOfMenu+orderedMenu.get(menuName));
    		return;
    	}
    	if((numberOfMenu)>99) {
			System.out.println("99개 이상 주문을 불가합니다. 주문 수량이 99로 조정됩니다");
			orderedMenu.put(menuName, 99);
			return;
		}
    	orderedMenu.put(menuName, numberOfMenu);
    }
    public void printReceipt() {
    	Iterator<String> keySetIterator = orderedMenu.keySet().iterator();
    	while(keySetIterator.hasNext()) {
    		String key = keySetIterator.next();
    		System.out.println(key + " " + orderedMenu.get(key) + " " + orderedMenu.get(key)*getMenuPrice(key));
    	}
    }
    public int getMenuPrice(String menuName) {
    	for(int i=0;i<menus.size();i++) {
    		if(menus.get(i).getName().contentEquals(menuName)) {
    			return menus.get(i).getPrice();
    		}
    	}
    	return 0;
    }
    public int calculateDiscount() {
    	int count = 0;
    	Iterator<String> keySetString = orderedMenu.keySet().iterator();
    	while(keySetString.hasNext()) {
    		String key = keySetString.next();
    		if(!(key.equals("콜라")||key.equals("사이다"))) {
    			count = count+ orderedMenu.get(key);
    			
    		}
    	}
    	if(count == 0) {
    		return 0;
    	}
    	count = (count/10)*10000;
    	return count;
    }
    public int getTotalPrice(int methodOfPayment) {
    	int totalPrice = 0;
    	int discount = calculateDiscount();
    	Iterator<String> keySetString = orderedMenu.keySet().iterator();
    	while(keySetString.hasNext()) {
    		String key = keySetString.next();
    		totalPrice = totalPrice + getMenuPrice(key) * orderedMenu.get(key);
    	}
    	totalPrice = totalPrice-discount;
    	if(methodOfPayment==1) {
    		return totalPrice;
    	}
    	return (int) (totalPrice*0.95);
    }
    public void clearOder() {
    	orderedMenu.clear();
    }
}
