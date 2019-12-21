import domain.runner.OrderRunner;
import domain.runner.PayRunner;
import view.InputView;
import view.OutputView;

import static util.ErrorMessage.INVALID_RUNNER_NUMBER;

public class Application {

    public static final int CLOSE_NUMBER = 3;

    public static void main(String[] args) {
        int selectRunner = selectRunner();
        while (selectRunner != CLOSE_NUMBER) {
            runByRunnerNumber(selectRunner);
            selectRunner = selectRunner();
        }
    }

    public static int selectRunner() {
        OutputView.printMain();
        return InputView.inputRunnerNumber();
    }

    private static void runByRunnerNumber(int selectRunner) {
        if (selectRunner == PayRunner.SELECT_NUMBER) {
            PayRunner.runPay();
            return;
        }
        if (selectRunner == OrderRunner.SELECT_NUMBER) {
            OrderRunner.runOrder();
            return;
        }
        throw new IllegalArgumentException(INVALID_RUNNER_NUMBER);
    }

}
