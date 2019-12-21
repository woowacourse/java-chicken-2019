package domain;

/**
 * Menu에 기본생성자를 추가할 수 없다.
 * Menu의 필드(인스턴스변수)를 추가할 수 없다.
 * 단,기존필드(인스턴스변수)의데이터타입은변경할수있다.
 * 필드(인스턴스변수)의 접근제어자는 private으로 구현해야한다.
 */
public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
