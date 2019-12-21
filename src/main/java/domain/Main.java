package domain;

/**
 * @author : Kim SeYun
 * @ClassName : Main
 * @ClassExplanation : 기능 객체
 * @Date : 2019. 12. 21
 * @Copyright (c) 2019 SeYun Kim
 */
public class Main {
    private final int number;
    private final String name;

    public Main(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }

    public boolean mainInputCheck(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }
}