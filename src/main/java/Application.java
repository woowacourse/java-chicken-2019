import Service.PosService;
import domain.NextStep;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        PosService posService = new PosService();
        NextStep nextStep;

        do {
            OutputView.printMain();
            nextStep = new NextStep(InputView.inputNextStep());
            if (nextStep.isExit()) return;
            posService.run(nextStep);
        }
        while (!nextStep.isExit());
    }
}
