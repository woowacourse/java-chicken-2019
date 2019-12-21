import domain.Order;
import domain.OrderList;
import domain.OrderForm;
import view.InputView;
import view.OutputView;

public class Application {
    private static final int EXIT = 3;
    public static void main(String[] args) {
        int functionNumber;

        do {
            OutputView.printFunctions();
            functionNumber = InputView.inputFunctionNumber();

            if (functionNumber == 1) {
                //functions order  order UI
                OrderList list = new OrderList();
                OrderForm order = new OrderForm();
            }
        } while (!(functionNumber == EXIT));

        OutputView.printExit();

    }


}
