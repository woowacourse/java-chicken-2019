import java.util.List;

import domain.FunctionNumber;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
    	FunctionNumber functionNumber;
    	OutputView.printFunction();
    	GetOrder getOrder = new GetOrder();
    	
    	do {
    		functionNumber = InputView.inputFunctionNumber();
    		
    		if (functionNumber.isOne()) {
    			getOrder.run();
    		}
    		if (functionNumber.isTwo()) {
    			
    		}
    	} while (!functionNumber.isThree());    

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
