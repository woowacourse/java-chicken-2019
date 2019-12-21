package control;

import view.InputView;

public class Control {

    public static void payAndSelect() {
        int key = 0;
        while (key != 3) {
            key = InputView.inputFunctionNumber();

        }

    }
}
