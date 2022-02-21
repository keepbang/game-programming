package skill.domain;

import ability.domain.CharacterAbility;
import ability.domain.StatusType;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.UltimateCharacterTest.generateUltimateCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class InvincibleTest {

    @Test
    @DisplayName("휴먼 궁극 스킬 : 무적 상태")
    public void invincible() {
        // given
        Character human = generateUltimateCharacter("human");
        // when
        boolean isUsedSkill = human.castSkill(Skill.INVINCIBLE);
        CharacterAbility ability = human.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentStatus()).isEqualTo(StatusType.INVINCIBLE);
    }

}