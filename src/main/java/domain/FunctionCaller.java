package domain;

public class FunctionCaller {
    public static void callFunction(final int functionNumber) {

        if (ProvidingFunctionRepository.isOrderRegistration(functionNumber)) {
            new OrderRegistration().resgistOrder();
        }

        if (ProvidingFunctionRepository.isPayment(functionNumber)) {
            new Payment().pay();
        }

        if (ProvidingFunctionRepository.isExit(functionNumber)) {

        }

    }
}
