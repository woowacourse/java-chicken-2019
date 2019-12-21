package domain;

import exception.InvalidInputException;

public class Count {

    private int count;

    public Count(int count) {
        if (count < 0) {
            throw new InvalidInputException("수량은 0이하일 수 없습니다.");
        }
        this.count = count;
    }

    void addCount(int count) {
        this.count += count;
    }

    int getCount() {
        return count;
    }

}
