package common.util;

public final class TimeUtil {
    private TimeUtil() {
    }

    public static long secondToNanos(double second) {
        return (long) (second * 1_000_000_000);
    }
}
