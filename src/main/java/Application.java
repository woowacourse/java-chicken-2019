import Service.PosService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        PosService posService = new PosService();

        OutputView.printMain();
        int nextStep = InputView.inputNextStep();

        posService.run();
    }
}
