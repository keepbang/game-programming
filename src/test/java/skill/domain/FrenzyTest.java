package skill.domain;

import ability.domain.Ability;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.UltimateCharacterTest.generateUltimateCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class FrenzyTest {

    @Test
    @DisplayName("오크 궁극 스킬 : 공격력 500% 상승")
    public void frenzy() {
        // given
        Character orc = generateUltimateCharacter("orc");
        // when
        boolean isUsedSkill = orc.castSkill(Skill.FRENZY);
        Ability ability = orc.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentPower()).isEqualTo(60);
    }
}