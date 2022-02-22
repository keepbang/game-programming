package ability.domain;

import common.util.Rate;

import java.util.Objects;

public class AvoidRate extends BuffAbility {
    private int avoidRate;

    public AvoidRate(int avoidRate) {
        this.avoidRate = avoidRate;
    }

    public boolean isAvoid(Rate rate) {
        return currentAvoidRate() >= rate.getRate();
    }

    public int currentAvoidRate() {
        return avoidRate + avoidRate * getBuffPercent() / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoidRate avoidRate1 = (AvoidRate) o;
        return avoidRate == avoidRate1.avoidRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(avoidRate);
    }
}
