package character.domain;

import ability.domain.CharacterAbility;

public class Elf extends Character {
    public Elf(CharacterAbility ability) {
        super(ability, CharacterType.ELF);
    }
}
