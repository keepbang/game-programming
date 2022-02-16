package character.domain;

import ability.domain.Ability;

public class UltimateCharacterTest {
    private static final Ability ULTIMATE_ABILITY = Ability.init(99, 100, 100, 10, 0.7, 10, 50);

    public static Character generateUltimateCharacter(String characterType) {
        return CharacterType.generateCharacter(characterType, ULTIMATE_ABILITY);
    }
}
