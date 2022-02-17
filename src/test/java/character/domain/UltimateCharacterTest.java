package character.domain;

import ability.domain.Ability;

public class UltimateCharacterTest {
    public static Character generateUltimateCharacter(String characterType) {
        Ability ultimateAbility = Ability.init(99, 100, 100, 10, 0.7, 10, 50);
        return CharacterRace.generateCharacter(characterType, ultimateAbility);
    }
}
