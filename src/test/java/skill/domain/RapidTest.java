package skill.domain;

import ability.domain.CharacterAbility;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.UltimateCharacterTest.generateUltimateCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class RapidTest {

    @Test
    @DisplayName("엘프 궁극 스킬 : 공격속도 500% 상승")
    public void rapid() {
        // given
        Character elf = generateUltimateCharacter("elf");
        // when
        boolean isUsedSkill = elf.castSkill(Skill.RAPID);
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(elf.currentAttackSpeed()).isEqualTo(0.12);
    }

}