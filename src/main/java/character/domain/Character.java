package character.domain;

import ability.domain.Ability;

import java.util.Objects;

public abstract class Character {
    Ability ability;

    public Character(Ability ability) {
        this.ability = ability;
    }

    public Ability getAbility() {
        return ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(ability, character.ability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ability);
    }
}
