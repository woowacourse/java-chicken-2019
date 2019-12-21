package domain;

import domain.model.PayType;
import domain.model.Receipt;
import domain.repository.PayRepository;
import util.InputValidator;
import view.InputView;
import view.OutputView;

/**
 * 결제와 관련된 일을 담당하는 클래스
 */
public class PayManager {
    private PayType[] payTypes = {PayType.CASH, PayType.CARD};

    private int inputPayType() {
        String input = "";

        do {
            input = InputView.inputPayType(payTypes);
        } while (!InputValidator.isNumber(input));

        return Integer.parseInt(input);
    }

    private String selectPayType() {
        int payType = inputPayType();

        while (!PayRepository.isExist(payType)) {
            OutputView.printNotExistPayment();
            payType = inputPayType();
        }

        return PayRepository.search(payType).getTypeName();
    }

    public boolean processPayment(Receipt receipt) {
        if (!receipt.hasOrder()) {
            OutputView.printNoOrder();
            return false;
        }

        int total = receipt.getTotalPrice();
        String payType = selectPayType();
        OutputView.printPaymentResult(payType, total);
        return true;
    }
}
