package Controller;

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
