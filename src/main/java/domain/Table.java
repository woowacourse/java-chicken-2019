package domain;

/**
 * 기본생성자 추가 불가능
 * 필드 private
 * Note : 여기서는 필드를 추가해도 된다.
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
}
