import Service.PosService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        PosService posService = new PosService();
        int nextStep;

        do {
            OutputView.printMain();
            nextStep = InputView.inputNextStep();
            if (nextStep == 3) return;
            posService.run(nextStep);
        }
        while (nextStep != 3);
    }
}
