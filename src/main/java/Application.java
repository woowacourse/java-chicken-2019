import domain.FunctionNumber;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
    	FunctionNumber functionNumber;
    	GetOrder getOrder = new GetOrder();
    	Payment payment = new Payment();
    	
    	do {
    		OutputView.printFunction();
    		functionNumber = InputView.inputFunctionNumber();
    		
    		if (functionNumber.isOne()) {
    			getOrder.run();
    		}
    		if (functionNumber.isTwo()) {
    			//payment.run();
    		}
    	} while (!functionNumber.isThree());
    }
}
