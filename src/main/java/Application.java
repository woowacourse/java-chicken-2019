
import domain.runner.RunnerType;
import exception.ExitException;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        int selectRunner = selectRunner();
        while (true) {
            RunnerType runnerType = RunnerType.findRunnerType(selectRunner);
            try {
                runnerType.runByRunnerType();
            } catch (ExitException e) {
                break;
            }
            selectRunner = selectRunner();
        }
    }

    public static int selectRunner() {
        OutputView.printMain();
        return InputView.inputRunnerNumber();
    }

}
