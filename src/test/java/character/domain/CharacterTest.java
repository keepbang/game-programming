package character.domain;

import ability.domain.Ability;
import common.exception.WrongCharacterTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    private static final Ability TEST_ABILITY = Ability.init(1, 100, 100, 10, 0.7, 10, 50);

    public static Character generateTestCharacter(String characterType) {
        return CharacterType.generateCharacter(characterType, TEST_ABILITY);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "human", "elf", "orc"
    })
    @DisplayName("캐릭터 생성")
    public void generateCharacterTest(String characterType) {
        // given
        // when
        Character actual = generateTestCharacter(characterType);
        // then
        assertEquals(actual.getAbility(), TEST_ABILITY);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "", "people", "elff"
    })
    @DisplayName("잘못된 종족이 입력되었을 경우")
    public void generateCharacterFailTest(String characterType) {
        assertThrows(WrongCharacterTypeException.class,
                () -> CharacterType.generateCharacter(characterType, TEST_ABILITY),
                "잘못된 종족을 입력하였습니다.");
    }
}