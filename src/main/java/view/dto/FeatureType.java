package view.dto;

public class FeatureType {
    int type;

    public FeatureType(int featureType) {
        if (featureType == 1 || featureType == 2 || featureType == 3) {
            this.type = featureType;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int getType() {
        return type;
    }

    public boolean isTypeOrder() {
        return type == 1;
    }

    public boolean isTypePayment() {
        return type == 2;
    }

    public boolean isTypeEnd() {
        return type == 3;
    }
}
