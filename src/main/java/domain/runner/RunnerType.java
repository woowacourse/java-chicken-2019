package domain.runner;

import exception.ExitException;

import java.util.Arrays;

import static util.ErrorMessage.INVALID_RUNNER_NUMBER;

public enum RunnerType {

    ORDER_RUNNER(1) {
        @Override
        public void runByRunnerType() {
            OrderRunner.runOrder();
        }
    },
    PAY_RUNNER(2) {
        @Override
        public void runByRunnerType() {
            PayRunner.runPay();
        }
    },
    CLOSE(3) {
        @Override
        public void runByRunnerType() {
            throw new ExitException();
        }
    };


    private int selectNumber;

    RunnerType(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public static RunnerType findRunnerType(int selectNumber) {
        return Arrays.stream(RunnerType.values())
                .filter(s -> s.selectNumber == selectNumber)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(INVALID_RUNNER_NUMBER);
                });
    }

    public void runByRunnerType() {
    }


}
