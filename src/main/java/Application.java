import domain.FunctionNumber;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
    	FunctionNumber functionNumber;
    	
    	do {
    		OutputView.printFunction();
    		functionNumber = InputView.inputFunctionNumber();

    		initiateGetOrder(functionNumber);
    		initiatePayment(functionNumber);
    	} while (!functionNumber.isThree());
    }
    
    public static void initiateGetOrder(FunctionNumber functionNumber) {
    	if (functionNumber.isOne()) {
    		GetOrder getOrder = new GetOrder();
    		getOrder.run();
    	}
    }
    
    public static void initiatePayment(FunctionNumber functionNumber) {
    	if (functionNumber.isTwo()) {
    		Payment payment = new Payment();
    		payment.run();
    	}
    }
}
