package character.domain;

import ability.domain.CharacterAbility;

public class Human extends Character {
    public Human(CharacterAbility ability) {
        super(ability, CharacterType.HUMAN);
    }
}
