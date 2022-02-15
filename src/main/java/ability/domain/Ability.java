package ability.domain;

import java.util.Objects;

public class Ability {
    private Level level;
    private HealthPoint healthPoint;
    private ManaPoint manaPoint;
    private int attack;
    private AttackSpeed attackSpeed;
    private int defense;
    private AvoidRate avoidRate;

    private Ability(Level level, HealthPoint healthPoint, ManaPoint manaPoint, int attack, AttackSpeed attackSpeed, int defense, AvoidRate avoidRate) {
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
                new AttackSpeed(attackSpeed),
                defense,
                new AvoidRate(avoidRate));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability = (Ability) o;
        return attack == ability.attack
                && defense == ability.defense
                && Objects.equals(level, ability.level)
                && Objects.equals(healthPoint, ability.healthPoint)
                && Objects.equals(manaPoint, ability.manaPoint)
                && Objects.equals(attackSpeed, ability.attackSpeed)
                && Objects.equals(avoidRate, ability.avoidRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, healthPoint, manaPoint, attack, attackSpeed, defense, avoidRate);
    }
}
