package domain;

public class PosPower {
    private boolean power;

    public PosPower() {
        this.power = true;
    }

    public void turnOff() {
        this.power = false;
    }

    public boolean isOn() {
        return this.power == true;
    }
}