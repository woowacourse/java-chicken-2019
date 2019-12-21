package exception;

import view.OutputView;

public class ExitException extends RuntimeException {
    public ExitException() {
        OutputView.printExitMessage();
    }
}
