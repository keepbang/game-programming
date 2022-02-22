package ability.domain;

import common.util.Rate;

import java.time.LocalDateTime;
import java.util.Objects;

public class CharacterAbility extends CommonAbility {
    private Level level;
    private ManaPoint manaPoint;
    private AttackSpeed attackSpeed;
    private AvoidRate avoidRate;
    private Status status;

    private CharacterAbility(Level level, HealthPoint healthPoint, ManaPoint manaPoint, Power power, AttackSpeed attackSpeed, Defense defense, AvoidRate avoidRate) {
        super(healthPoint, power, defense);
        this.level = level;
        this.manaPoint = manaPoint;
        this.attackSpeed = attackSpeed;
        this.avoidRate = avoidRate;
        this.status = new Status(StatusType.ALIVE);
    }

    public CharacterAbility(CharacterAbility ability) {
        super(ability);
        this.level = ability.level;
        this.manaPoint = ability.manaPoint;
        this.attackSpeed = ability.attackSpeed;
        this.avoidRate = ability.avoidRate;
        this.status = ability.status;
    }

    public static CharacterAbility init(int level, int healthPoint, int manaPoint, int power, double attackSpeed, int defense, int avoidRate) {
        return new CharacterAbility(new Level(level),
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

    public void changeStatus(StatusType type, LocalDateTime unlockStatusTime) {
        status.change(type, unlockStatusTime);
    }

    public void attackSpeedBuff(int percent, long durationSecond) {
        attackSpeed.changeBuff(percent, durationSecond);
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

    public int currentAvoidRate() {
        return avoidRate.currentAvoidRate();
    }

    public double currentAttackSpeed() {
        return attackSpeed.currentDelaySecond();
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

    public boolean nextAttack() {
        return attackSpeed.nextAttack();
    }

    public void increaseByDelay() {
        attackSpeed.increaseByDelay();
    }

    public boolean isAvoid(Rate rate) {
        return avoidRate.isAvoid(rate);
    }

    public CharacterAbility levelUp() {
        level.levelUp();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterAbility that = (CharacterAbility) o;
        return Objects.equals(level, that.level)
                && Objects.equals(manaPoint, that.manaPoint)
                && Objects.equals(attackSpeed, that.attackSpeed)
                && Objects.equals(avoidRate, that.avoidRate)
                && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, manaPoint, attackSpeed, avoidRate, status);
    }
}
