package weapon.domain;

import ability.domain.Ability;
import character.domain.CharacterType;

public abstract class Weapon {
    private final CharacterType characterType;

    public abstract void mount(Ability ability);
    public abstract void unMount(Ability ability);

    public Weapon(CharacterType characterType) {
        this.characterType = characterType;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }
}
