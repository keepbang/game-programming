package ability.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ability {
    private Level level;
    private HealthPoint healthPoint;
    private ManaPoint manaPoint;
    private Power power;
    private AttackSpeed attackSpeed;
    private Defense defense;
    private AvoidRate avoidRate;
    private Status status;

    private Ability(Level level, HealthPoint healthPoint, ManaPoint manaPoint, Power power, AttackSpeed attackSpeed, Defense defense, AvoidRate avoidRate) {
        this.level = level;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
        this.power = power;
        this.attackSpeed = attackSpeed;
        this.defense = defense;
        this.avoidRate = avoidRate;
        this.status = new Status(StatusType.ALIVE);
    }

    public static Ability init(int level, int healthPoint, int manaPoint, int power, double attackSpeed, int defense, int avoidRate) {
        return new Ability(new Level(level),
                new HealthPoint(healthPoint),
                new ManaPoint(manaPoint),
                new Power(power),
                new AttackSpeed(attackSpeed),
                new Defense(defense),
                new AvoidRate(avoidRate));
    }

    public boolean useMana(final ManaPoint usedMana) {
        return manaPoint.useMana(usedMana);
    }

    public void upHp(int healPoint) {
        healthPoint.healHp(healPoint);
    }

    public void downHp(int damage) {
        healthPoint.downHp(damage);
        if (healthPoint.isDie()) {
            changeStatus(StatusType.DIE, LocalDateTime.MIN);
        }
    }

    public void changeStatus(StatusType type, LocalDateTime unlockStatusTime) {
        status.change(type, unlockStatusTime);
    }

    public void powerBuff(int percent, long durationSecond) {
        power.changeBuff(percent, durationSecond);
    }

    public void attackSpeedBuff(int percent, long durationSecond) {
        attackSpeed.changeBuff(percent, durationSecond);
    }

    public void defenseBuff(int percent, long durationSecond) {
        defense.changeBuff(percent, durationSecond);
    }

    public void avoidBuff(int percent, long durationSecond) {
        avoidRate.changeBuff(percent, durationSecond);
    }

    public boolean isUltimateLevel() {
        return level.isUltimate();
    }

    public StatusType currentStatus() {
        return status.currentStatus();
    }

    public double currentPower() {
        return power.currentPower();
    }

    public int currentDefense() {
        return defense.currentDefense();
    }

    public int currentAvoidRate() {
        return avoidRate.currentAvoidRate();
    }

    public double currentAttackSpeed() {
        return attackSpeed.currentDelaySecond();
    }

    public Power getPower() {
        return power;
    }

    public AttackSpeed getAttackSpeed() {
        return attackSpeed;
    }

    public void mountWeapon(BuffAbility buffAbility, int percent) {
        buffAbility.mountWeapon(percent);
    }

    public void unMountWeapon(BuffAbility buffAbility, int percent) {
        buffAbility.unMountWeapon(percent);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return Objects.equals(level, ability.level)
                && Objects.equals(healthPoint, ability.healthPoint)
                && Objects.equals(manaPoint, ability.manaPoint)
                && Objects.equals(power, ability.power)
                && Objects.equals(attackSpeed, ability.attackSpeed)
                && Objects.equals(defense, ability.defense)
                && Objects.equals(avoidRate, ability.avoidRate)
                && Objects.equals(status, ability.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, healthPoint, manaPoint, power, attackSpeed, defense, avoidRate, status);
    }
}
