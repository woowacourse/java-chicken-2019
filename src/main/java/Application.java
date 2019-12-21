import domain.*;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String REGISTER_ORDER = "주문등록";
    private static final String DO_PAYMENT= "결제하기";
    private static final String EXIT_PROGRAM = "프로그램 종료";

    private ArrayList<String> functions;
    private Order order;

    public Application() {
        initializeFunctions();
        order = new Order();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        int input;

        OutputView.printMainScreen();
        OutputView.printFunctions(functions);
        input = getFunctionNumber();
        if (input == functions.indexOf(REGISTER_ORDER)) {
            order.getOrder();
        }
        if (input == functions.indexOf(DO_PAYMENT)) {
            System.out.println("구현 중입니다. 잠시만 기다려 주세요^^");
        }
        if (input == functions.indexOf(EXIT_PROGRAM)) {
            System.exit(0);
        }
    }

    private void initializeFunctions() {
        functions = new ArrayList<>();
        functions.add(REGISTER_ORDER);
        functions.add(DO_PAYMENT);
        functions.add(EXIT_PROGRAM);
    }

    private int getFunctionNumber() {
        return InputView.inputFuctionNumber(functions.size());
    }
}
