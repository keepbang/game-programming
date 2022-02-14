package ability.domain;

import java.util.Objects;

public class Ability {
    private Level level;
    private HealthPoint healthPoint;
    private ManaPoint manaPoint;
    private int attack;
    private double attackSpeed;
    private int defense;
    private AvoidRate avoidRate;

    private Ability(Level level, HealthPoint healthPoint, ManaPoint manaPoint, int attack, double attackSpeed, int defense, AvoidRate avoidRate) {
        this.level = level;
        this.healthPoint = healthPoint;
        this.manaPoint = manaPoint;
        this.attack = attack;
        this.attackSpeed = attackSpeed;
        this.defense = defense;
        this.avoidRate = avoidRate;
    }

    public static Ability init(int level, int healthPoint, int manaPoint, int attack, double attackSpeed, int defense, int avoidRate) {
        return new Ability(new Level(level),
                new HealthPoint(healthPoint),
                new ManaPoint(manaPoint),
                attack,
                attackSpeed,
                defense,
                new AvoidRate(avoidRate));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return level == ability.level
                && healthPoint == ability.healthPoint
                && manaPoint == ability.manaPoint
                && attack == ability.attack
                && Double.compare(ability.attackSpeed, attackSpeed) == 0
                && defense == ability.defense
                && avoidRate == ability.avoidRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, healthPoint, manaPoint, attack, attackSpeed, defense, avoidRate);
    }
}
