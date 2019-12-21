package domain;

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
        if(this.number == number){
            return false;
        }
        return true;
    }
}
