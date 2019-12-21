package domain.menu;

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

    public Menu(final Integer number, final String name, final Category category, final Integer price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isSameMenu(Menu menu) {
        return this.number.equals(menu.getNumber());
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
