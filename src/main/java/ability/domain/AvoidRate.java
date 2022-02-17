package ability.domain;

import common.util.Rate;

import java.util.Objects;

public class AvoidRate extends CommonAbility {
    private int avoidRate;

    public AvoidRate(int avoidRate) {
        this.avoidRate = avoidRate;
    }

    public boolean isAvoid(Rate rate) {
        return avoidRate > rate.getRate();
    }

    public int currentAvoidRate() {
        return avoidRate + avoidRate * buffPercent / 100;
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
