package ability.domain;

import java.util.Objects;

public class CommonAbility {
    private HealthPoint healthPoint;
    private Power power;
    private Defense defense;

    public CommonAbility(HealthPoint healthPoint, Power power, Defense defense) {
        this.healthPoint = healthPoint;
        this.power = power;
        this.defense = defense;
    }

    public void upHp(int healPoint) {
        healthPoint.healHp(healPoint);
    }

    public void downHp(int damage) {
        healthPoint.downHp(damage);
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
