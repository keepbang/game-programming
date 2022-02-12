package ability.domain;

import common.exception.MinimumHealthPointException;

public class HealthPoint {
    private static final int MIN_HEALTH_POINT = 0;

    private final int maxHealthPoint;
    private int healthPoint;

    public HealthPoint(int healthPoint) {
        validate(healthPoint);
        this.healthPoint = healthPoint;
        this.maxHealthPoint = healthPoint;
    }

    private void validate(int healthPoint) {
        if (healthPoint <= MIN_HEALTH_POINT) {
            throw new MinimumHealthPointException();
        }
    }

    public void upHp(int healPoint) {
        healthPoint = remainHealthPoint(healthPoint + healPoint);
    }

    public void downHp(int damage) {
        healthPoint = remainHealthPoint(healthPoint - damage);
    }

    private int remainHealthPoint(int remain) {
        if (remain > maxHealthPoint) {
            return maxHealthPoint;
        }

        if (remain <= MIN_HEALTH_POINT) {
            return 0;
        }
        return remain;
    }

    public int getCurrentHp() {
        return healthPoint;
    }
}
