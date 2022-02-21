package ability.domain;

import common.util.ValueUtil;

import java.util.Objects;

public class Power extends BuffAbility {
    private int power;

    public Power(int power) {
        this.power = power;
    }

    public double currentPower() {
        return ValueUtil.round(calcBuffedPower(), 2);
    }

    private double calcBuffedPower() {
        return power + (power * getBuffPercent() / 100.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power1 = (Power) o;
        return power == power1.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power);
    }
}
