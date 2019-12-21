package domain.model;

/**
 * 정수 범위를 나타내는 클래스
 */
public final class Range {
    private static final String MSG_RANGE_ERROR = "end는 begin보다 큰 값이어야 합니다.";
    private final int begin;
    private final int end;

    public Range(int begin, int end) {
        if (begin >= end) {
            throw new IllegalArgumentException(MSG_RANGE_ERROR);
        }

        this.begin = begin;
        this.end = end;
    }

    public boolean verify(int num) {
        return num <= end && num >= begin;
    }

    @Override
    public String toString() {
        return "[" + begin + "~" + end + "]";
    }
}
