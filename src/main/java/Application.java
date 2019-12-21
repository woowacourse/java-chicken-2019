import domain.MainOptions;
import domain.TableManager;
import util.InputValidator;
import view.InputView;
import view.OutputView;

public class Application {
    private static final int OPTION_BEGIN = 1;
    private TableManager manager = new TableManager();
    private MainOptions[] options = new MainOptions[]{
            MainOptions.ADD_ORDER,
            MainOptions.PAYMENT,
            MainOptions.EXIT
    };

    public static void main(String[] args) {
        Application pos = new Application();
        pos.startPost();
        pos.exit();
    }

    private void startPost() {
        MainOptions option = MainOptions.NONE;

        while (!option.isStop()) {
            OutputView.printMain(options);
            option = options[selectOption()];
            processOption(option);
        }
    }

    private int selectOption() {
        String input = "";

        do {
            input = InputView.inputMainOption();
        } while (!InputValidator.isNumberInRange(input, OPTION_BEGIN, options.length));

        return Integer.parseInt(input) - 1;
    }

    private void processOption(MainOptions option) {
        switch (option) {
            case ADD_ORDER:
                startOrder();
                break;
            case PAYMENT:
                break;
        }
    }

    private void startOrder() {
        manager.choiceTable();
    }

    private void exit() {
        InputView.closeView();
    }
}
