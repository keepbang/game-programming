package common.util;

public final class ValueUtil {
    private ValueUtil() {
    }

    public static double round(double value, int squared) {
        double pow = Math.pow(10, squared);
        return Math.round(value * pow) / pow;
    }
}
