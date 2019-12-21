import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final int action = InputView.inputMain();
        ErrorDetect.mainInputError(action);
        actionLogic(action);
    }

    public static void actionLogic(int action) {
        if (action == 3)
            System.exit(0);
        RunPOS runPOS = new RunPOS(action);
    }

}
