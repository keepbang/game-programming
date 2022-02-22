package ability.domain;

import java.util.Objects;

public class CommonAbility {
    private HealthPoint healthPoint;
    private Power power;
    private Defense defense;

    protected CommonAbility(HealthPoint healthPoint, Power power, Defense defense) {
        this.healthPoint = healthPoint;
        this.power = power;
        this.defense = defense;
    }

    public CommonAbility(CommonAbility ability) {
        this(ability.healthPoint, ability.power, ability.defense);
    }

    public void upHp(int healPoint) {
        healthPoint.healHp(healPoint);
    }

    public void downHp(double damage) {
        healthPoint.downHp(damage - currentDefense());
    }

    public void powerBuff(int percent, long durationSecond) {
        power.changeBuff(percent, durationSecond);
    }

    public void defenseBuff(int percent, long durationSecond) {
        defense.changeBuff(percent, durationSecond);
    }

    public double currentPower() {
        return power.currentPower();
    }

    public int currentDefense() {
        return defense.currentDefense();
    }

    public int currentHp() {
        return healthPoint.getCurrentHp();
    }

    public boolean isDie() {
        return healthPoint.isDie();
    }

    public Power getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonAbility that = (CommonAbility) o;
        return Objects.equals(healthPoint, that.healthPoint)
                && Objects.equals(power, that.power)
                && Objects.equals(defense, that.defense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoint, power, defense);
    }
}
