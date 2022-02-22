package skill.domain;

import ability.domain.CharacterAbility;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class SteamTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "human", "elf", "orc"
    })
    @DisplayName("공통 스킬 : 공격력 20% 상승")
    public void steam(String characterType) {
        // given
        Character character = makeCharacter(characterType);
        // when
        boolean isUsedSkill = character.castSkill(Skill.STEAM);
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(character.currentPower()).isEqualTo(12);
    }

}