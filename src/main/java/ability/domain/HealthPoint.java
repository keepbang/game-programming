package ability.domain;

import common.exception.MinimumHealthPointException;

import java.util.Objects;

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

    public void healHp(int healPoint) {
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

    public boolean isDie() {
        return healthPoint <= MIN_HEALTH_POINT;
    }

    public int getCurrentHp() {
        return healthPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthPoint that = (HealthPoint) o;
        return maxHealthPoint == that.maxHealthPoint
                && healthPoint == that.healthPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHealthPoint, healthPoint);
    }
}
