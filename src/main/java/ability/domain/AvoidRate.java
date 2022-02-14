package ability.domain;

import common.util.Rate;

public class AvoidRate {
    private int avoidRate;

    public AvoidRate(int avoidRate) {
        this.avoidRate = avoidRate;
    }

    public boolean isAvoid(Rate rate) {
        return avoidRate > rate.getRate();
    }

}
