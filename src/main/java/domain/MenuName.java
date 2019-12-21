package domain;

public class MenuName {
    private String name;

    public MenuName(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("이름은 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
