package weapon.domain;

import ability.domain.CharacterAbility;
import character.domain.CharacterType;

public abstract class Weapon {
    private final CharacterType characterType;

    public abstract void mount(CharacterAbility ability);
    public abstract void unMount(CharacterAbility ability);

    public Weapon(CharacterType characterType) {
        this.characterType = characterType;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }
}
