import domain.OrderForm;
import domain.OrderList;
import domain.Payment;
import view.InputView;
import view.OutputView;

public class Application {
    private static final int ORDER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 3;
    ;
    public static void main(String[] args) {
        int functionNumber;

        do {
            OutputView.printFunctions();
            functionNumber = InputView.inputFunctionNumber();

            if (functionNumber == ORDER) {
                OrderForm order = new OrderForm();
            }

            if (functionNumber == PAY) {
                Payment pay = new Payment();
            }
        } while (!(functionNumber == EXIT));

        OutputView.printExit();

    }
}
