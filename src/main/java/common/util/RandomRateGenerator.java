package common.util;

public final class RandomRateGenerator implements Rate {
    private static final int MAX_VALUE = 100;

    private RandomRateGenerator() {
    }

    private static class RandomHolder {
        public static final RandomRateGenerator randomNumber = new RandomRateGenerator();
    }

    public static RandomRateGenerator getInstance() {
        return RandomHolder.randomNumber;
    }

    @Override
    public int getRate() {
        return (int) (Math.random() * MAX_VALUE);
    }

}
