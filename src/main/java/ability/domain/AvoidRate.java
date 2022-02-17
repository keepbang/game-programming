package ability.domain;

import common.util.Rate;

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

}
