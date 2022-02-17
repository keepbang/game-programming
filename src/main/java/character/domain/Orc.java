package character.domain;

import ability.domain.Ability;

public class Orc extends Character {
    public Orc(Ability ability) {
        super(ability, CharacterType.ORC);
    }
}
