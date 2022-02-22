package character.domain;

import ability.domain.CharacterAbility;
import common.exception.WrongCharacterTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharacterTest {
    public static Character makeCharacter(String characterType) {
        CharacterAbility ability = CharacterAbility.init(1, 100, 100, 10, 0.7, 10, 50);
        return CharacterRace.generateCharacter(characterType, ability);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "human", "elf", "orc"
    })
    @DisplayName("캐릭터 생성")
    public void generateCharacterTest(String characterType) {
        // given
        // when
        Character actual = makeCharacter(characterType);
        Character excepted = makeCharacter(characterType);
        // then
        assertThat(actual).isEqualTo(excepted);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "", "people", "elff"
    })
    @DisplayName("잘못된 종족이 입력되었을 경우")
    public void generateCharacterFailTest(String characterType) {
        assertThatThrownBy(() -> makeCharacter(characterType))
                .isInstanceOf(WrongCharacterTypeException.class);
    }
}