package character.domain;

import ability.domain.CharacterAbility;
import common.exception.WrongCharacterTypeException;

import java.util.Arrays;
import java.util.function.Function;

public enum CharacterRace {
    HUMAN(Human::new),
    ELF(Elf::new),
    ORC(Orc::new);

    private final Function<CharacterAbility, Character> function;

    CharacterRace(Function<CharacterAbility, Character> function) {
        this.function = function;
    }

    public static Character generateCharacter(String type, CharacterAbility ability) {
        return Arrays.stream(values())
                .filter(characterType -> characterType.name()
                        .equals(type.toUpperCase()))
                .findFirst()
                .orElseThrow(WrongCharacterTypeException::new)
                .function.apply(ability);
    }
}
