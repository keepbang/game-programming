package ability.domain;

import java.util.Objects;

public class Defense extends BuffAbility {
    private int defense;

    public Defense(int defense) {
        this.defense = defense;
    }

    public int currentDefense() {
        return defense + defense * getBuffPercent() / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defense defense1 = (Defense) o;
        return defense == defense1.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defense);
    }
}
