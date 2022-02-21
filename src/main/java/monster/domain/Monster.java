package monster.domain;

import ability.domain.Attack;
import ability.domain.Defense;
import ability.domain.HealthPoint;
import common.util.Rate;

import java.util.Objects;

public class Monster implements CounterAttack {
    private static final int COUNTER_RATE = 30;
    private static final double COUNTER_DAMAGE_PERCENT = 0.7;

    private final HealthPoint healthPoint;
    private final Attack attack;
    private final Defense defense;

    public Monster(int healthPoint, int attack, int defense) {
        this.healthPoint = new HealthPoint(healthPoint);
        this.attack = new Attack(attack);
        this.defense = new Defense(defense);
    }

    @Override
    public double counterDamage(Rate rate) {
        if (COUNTER_RATE >= rate.getRate()) {
            return attack.currentAttack() * COUNTER_DAMAGE_PERCENT;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(healthPoint, monster.healthPoint)
                && Objects.equals(attack, monster.attack)
                && Objects.equals(defense, monster.defense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoint, attack, defense);
    }
}
