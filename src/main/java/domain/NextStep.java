package domain;

public class NextStep {
    private static final int MAX = 3;
    private static final int MIN = 1;
    private static final int ORDER = 1;
    private static final int PAY = 2;
    private static final int EXIT = 3;

    private int nextStep;

    public NextStep(int nextStep) {
        validateBoundary(nextStep);
        this.nextStep = nextStep;
    }

    private void validateBoundary(int nextStep) {
        if (nextStep > MAX || nextStep < MIN) {
            throw new IllegalArgumentException("1이상 3이하의 값을 입력해주세요.");
        }
    }

    public boolean isOrder() {
        return nextStep == ORDER;
    }

    public boolean isPay() {
        return nextStep == PAY;
    }

    public boolean isExit() {
        return nextStep == EXIT;
    }
}
