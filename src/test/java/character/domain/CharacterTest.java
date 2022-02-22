package character.domain;

import ability.domain.CharacterAbility;
import common.exception.WrongCharacterTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import skill.domain.Skill;

import static ability.domain.CharacterAbilityTest.testCharacterAbility;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharacterTest {
    public static Character makeCharacter(String characterType) {
        CharacterAbility ability = testCharacterAbility();
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

    @Test
    @DisplayName("스킬 사용 시 마나 감소")
    public void downManaTest() {
        // given
        Character character = makeCharacter("human");
        // when
        boolean actual = character.castSkill(Skill.STEAM);
        // then
        assertThat(actual).isTrue();
        assertThat(character.currentMp()).isEqualTo(90);
    }

    @Test
    @DisplayName("마나가 없을 경우 스킬을 사용 할 수 없다.")
    public void downManaFailTest() {
        // given
        CharacterAbility ability = CharacterAbility.init(1, 100, 1, 10, 0.7, 10, 50);
        Character character = CharacterRace.generateCharacter("human", ability);
        // when
        boolean actual = character.castSkill(Skill.STEAM);
        // then
        assertThat(actual).isFalse();
        assertThat(character.currentMp()).isEqualTo(1);
    }
}