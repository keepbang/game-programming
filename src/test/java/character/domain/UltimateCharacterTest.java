package character.domain;

import ability.domain.CharacterAbility;

public class UltimateCharacterTest {
    public static Character generateUltimateCharacter(String characterType) {
        CharacterAbility ultimateAbility = CharacterAbility.init(99, 100, 100, 10, 0.7, 10, 50);
        return CharacterRace.generateCharacter(characterType, ultimateAbility);
    }
}
