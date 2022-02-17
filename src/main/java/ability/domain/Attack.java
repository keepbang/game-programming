package ability.domain;

import java.util.Objects;

public class Attack extends CommonAbility {
    private int attack;

    public Attack(int attack) {
        this.attack = attack;
    }

    public int currentAttack() {
        return attack + attack * buffPercent / 100;
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
