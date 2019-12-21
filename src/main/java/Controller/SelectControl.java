package Controller;

import java.util.List;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class SelectControl {
    public static int checkFunctionSelect(String function) {
	if(isStringInt(function)==false) {
	    OutputView.printFuctionSelectError();
	    return -1;
	}
	if(isOneTwoThree(Integer.parseInt(function))==false) {
	    OutputView.printFuctionSelectError();
	    return -1;
	}
	return Integer.parseInt(function);
    }
    
    public static int checkTableSelect(String tableNum,final List<Table> tables) {
	if(isStringInt(tableNum)==false) {
	    OutputView.printTaleSelectError();
	    return -1;
	}
	if(isInTable(tableNum,tables)==false) {
	    OutputView.printTaleSelectError();
	    return -1;
	}
	for(int i=0;i<tables.size();i++) {
	    if(tables.get(i).isMax()) {
		OutputView.printTableFullError();
		return -1;
	    }
	}
	return Integer.parseInt(tableNum);
    }
    
    public static int checkMenuSelect(String m,final List<Menu> menus) {
	if(isStringInt(m)==false) {
	    OutputView.printMenuSelectError();
	    return -1;
	}
	if(isInMenu(Integer.parseInt(m),menus)==false) {
	    OutputView.printMenuSelectError();
	    return -1;
	}
	return Integer.parseInt(m);
    }
    
    public static int checkMenuAmount(String amount,Table table) {
	if(isStringInt(amount)==false) {
	    OutputView.printMenutAmountError();
	    return -1;
	}
	if(isPositiveInteger(Integer.parseInt(amount))==false) {
	    OutputView.printMenutAmountError();
	    return -1;
	}
	if(table.getNumberSum()+Integer.parseInt(amount)>99) {
	    OutputView.printMenuAmountInputError();
	    return -1;
	}
	return Integer.parseInt(amount);
	
    }
    
    public static int checkPay(String pay) {
	if(isStringInt(pay)==false) {
	    OutputView.printPayInputError();
	    return -1;
	}
	if(isOneTwo(Integer.parseInt(pay))==false) {
	    OutputView.printPayInputError();
	    return -1;
	}
	return Integer.parseInt(pay);
    }
    
    public static boolean isOneTwo(int p) {
	if(p==1) {
	    return true;
	}
	if(p==2) {
	    return true;
	}
	return false;
    }
    
    public static boolean isPositiveInteger(int num) {
	if(num>=0) {
	    return true;
	}
	return false;
    }
    
    public static boolean isInMenu(int m,final List<Menu> menus) {
	for(final Menu menu : menus) {
	    if(menu.getNumber()==m) {
		return true;
	    }
	}
	return false;
    }
    
    public static boolean isInTable(String t,final List<Table> tables) {
	for(final Table table : tables) {
	    if(table.toString().equals(t)) {
		return true;
	    }
	}
	return false;
    }
    
    public static boolean isStringInt(String n) {
	 try {
	        Integer.parseInt(n);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
    }
    
    public static boolean isOneTwoThree(int n) {
	if(n==1 || n==2 || n==3) {
	    return true;
	}
	return false;
    }
}
