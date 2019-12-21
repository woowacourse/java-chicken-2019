package domain;
/**
 * 기본 생성자 추가 불가
 * 필드 추가 불가 : 필드 타입 변경은 가능
 * 필드 private 설정
 */

public class Menu {
    private final Integer number;
    private final String name;
    private final Category category;
    private final Integer price;

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
