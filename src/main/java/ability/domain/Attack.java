package ability.domain;

import common.util.ValueUtil;

import java.util.Objects;

public class Attack extends CommonAbility {
    private int attack;

    public Attack(int attack) {
        this.attack = attack;
    }

    public double currentAttack() {
        return ValueUtil.round(calcBuffedAttack(), 2);
    }

    private double calcBuffedAttack() {
        return attack + (attack * getBuffPercent() / 100.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attack attack1 = (Attack) o;
        return attack == attack1.attack;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack);
    }
}
