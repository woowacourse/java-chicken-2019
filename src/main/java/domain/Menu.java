package domain;

/*
* 다음 Menu 클래스를 활용해 구현해야 한다.
* •Menu에 기본 생성자를 추가할 수 없다.
* •Menu의 필드(인스턴스 변수)를 추가할 수 없다.
•단, 기존 필드(인스턴스 변수)의 데이터 타입은 변경할 수 있다.
•필드(인스턴스 변수)의 접근 제어자는 private으로 구현해야 한다.
* */
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
