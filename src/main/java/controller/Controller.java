package controller;

import domain.PosFunction;
import service.PosService;
import view.InputView;
import view.OutputView;

public class Controller {

    public static void run() {
        try {
            runWithoutExceptionCatch();
        } catch (Exception e) {
            OutputView.printExceptionMessage(e.getMessage());
        }
    }

    private static void runWithoutExceptionCatch() {
        PosFunction posFunction;

        do {
            OutputView.printPosFunctions(PosFunction.getPosFunctionsByCodeKoreanMap());
            posFunction = PosFunction.of(InputView.inputPosFunction());

            runOnce(posFunction);
        } while (posFunction != PosFunction.EXIT);
    }

    private static void runOnce(PosFunction posFunction) {
        if (posFunction == PosFunction.ORDER_REGISTRATION) {
            PosService.registerOrder();
        }
        if (posFunction == PosFunction.PAYMENT) {
            PosService.pay();
        }
    }
}
