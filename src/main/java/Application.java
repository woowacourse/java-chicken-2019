import view.InputView;

/**
 * main()이 있는 클래스. 사용자의 주문/결제/종료 요청에 대한 처리를 한다.
 */
public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        int action = InputView.inputAction();

        while (action != 3) {
            actionLogic(action);
            action = InputView.inputAction();
        }
    }

    public static void actionLogic(int action) {
        RunPOS runPOS = new RunPOS();
        if (action == 1) runPOS.order();
        if (action == 2) runPOS.pay();
    }
}
