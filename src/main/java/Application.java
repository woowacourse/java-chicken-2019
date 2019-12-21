
import domain.runner.RunnerType;
import exception.ExitException;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        while (true) {
            try {
                findRunnerTypeWithInput().runByRunnerType();
            } catch (ExitException e) {
                break;
            }
        }
    }

    public static int selectRunner() {
        OutputView.printMain();
        return InputView.inputRunnerNumber();
    }

    private static RunnerType findRunnerTypeWithInput() {
        try {
            return RunnerType.findRunnerType(selectRunner());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorRetryMessage(e);
            return findRunnerTypeWithInput();
        }
    }


}
