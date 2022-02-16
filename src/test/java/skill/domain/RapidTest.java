package skill.domain;

import ability.domain.Ability;
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
        Ability ability = elf.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentAttackSpeed()).isEqualTo(0.14);
    }

}