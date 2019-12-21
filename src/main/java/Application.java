import view.InputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final int action = InputView.inputMain();
        actionLogic(action);
    }

    public static void actionLogic(int action) {
        if (action == 3)
            System.exit(0);
        RunPOS runPOS = new RunPOS(action);
    }

}
