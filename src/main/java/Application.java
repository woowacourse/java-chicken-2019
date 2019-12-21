import domain.FunctionNumber;
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
    }
}
