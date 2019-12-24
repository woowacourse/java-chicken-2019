package view.dto;

public class FeatureType {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private int type;

    public FeatureType(int featureType) {
        if (featureType == ONE || featureType == TWO || featureType == THREE) {
            this.type = featureType;
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isTypeOrder() {
        return type == ONE;
    }

    public boolean isTypePayment() {
        return type == TWO;
    }
}
