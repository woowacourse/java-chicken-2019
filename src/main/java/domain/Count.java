package domain;

import exception.InvalidInputException;

public class Count {

    private int count;

    Count(int count) {
        if (count < 0) {
            throw new InvalidInputException(InvalidInputException.WRONG_COUNT_EXCEPTION);
        }
        this.count = count;
    }

    void addCount(int count) {
        if (this.count + count < 0) {
            throw new InvalidInputException(InvalidInputException.WRONG_COUNT_EXCEPTION);
        }
        this.count += count;
    }

    int getCount() {
        return count;
    }

}
