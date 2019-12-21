import view.InputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        int action = InputView.inputMain();
        while (action != 3) {
            actionLogic(action);
            action = InputView.inputMain();
        }
    }

    public static void actionLogic(int action) {
        RunPOS runPOS = new RunPOS();
        if (action == 1) runPOS.order();
        if (action == 2) runPOS.pay();
    }
}
