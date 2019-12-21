public class PosPower {
    private boolean power;

    public PosPower(boolean power) {
        this.power = power;
    }

    public void turnOn() {
        this.power = true;
    }

    public void turnOff() {
        this.power = false;
    }
}