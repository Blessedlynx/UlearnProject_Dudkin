package Data;

public class Whisker {
    private float highValue;
    private float lowValue;

    public Whisker(float highValue, float lowValue) {
        this.highValue = highValue;
        this.lowValue = lowValue;
    }

    public float getHighValue() {
        return highValue;
    }

    public float getLowValue() {
        return lowValue;
    }

    public String toString() {
        return String.format("%s, %s", highValue, lowValue);
    }
}
