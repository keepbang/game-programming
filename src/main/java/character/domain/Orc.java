package character.domain;

import ability.domain.CharacterAbility;

public class Orc extends Character {
    public Orc(CharacterAbility ability) {
        super(ability, CharacterType.ORC);
    }
}
