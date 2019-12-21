package domain;

/**
 * 이 어플리케이션에서 제공하는 기능 하나하나에 대한 객체
 */
public class ProvidingFunction {
    private int id;
    private String description;

    public ProvidingFunction(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
