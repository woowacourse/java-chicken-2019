package domain;

public class FunctionCaller {
    public static void callFunction(int functionNumber) {

        if (ProvidingFunctionRepository.isOrderRegistration(functionNumber)) {
            new OrderRegistration().controlOrderRegistration();
            return;
        }

        if (ProvidingFunctionRepository.isPayment(functionNumber)) {
            new Payment().paymentControl();
            return;
        }

    }
}
