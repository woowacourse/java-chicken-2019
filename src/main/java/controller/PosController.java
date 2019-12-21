package controller;

import view.OutputView;

import static view.InputView.getMainFunctionNumber;

public class PosController {

    public void posController() {
        OutputView.printMainPage();
        int funcDecideNumber;
        do {
            funcDecideNumber = setFunction();
            chooseOrderOrPay(funcDecideNumber);
        } while (funcDecideNumber != 3);
        return;

    }

    public int setFunction() {

        return getMainFunctionNumber();
    }

    public void chooseOrderOrPay(int inputNumber) {
        if (inputNumber == 3) {
            return;
        }

        if (inputNumber == 1) {
            OrderController orderController = new OrderController();
            orderController.orderController();
            return;
        }

        PaymentController paymentController = new PaymentController();
        paymentController.paymentController();
    }
}
