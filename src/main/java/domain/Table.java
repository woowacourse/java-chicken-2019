package domain;

/**
 * @author : Kim SeYun
 * @ClassName : Table
 * @ClassExplanation : 테이블 객체
 * @Date : 2019. 12. 17
 * @Copyright (c) 2019 SeYun Kim
 */
public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean tableInputCheck(int number) {
        return this.number == number;
    }
}