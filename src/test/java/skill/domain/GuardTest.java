package skill.domain;

import ability.domain.Ability;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.CharacterTest.generateTestCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class GuardTest {

    @Test
    @DisplayName("휴먼 스킬 사용 : 방어력 30% 상승")
    public void guard() {
        // given
        Character human = generateTestCharacter("human");
        // when
        boolean isUsedSkill = human.castSkill(Skill.GUARD);
        Ability ability = human.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentDefense()).isEqualTo(13);
    }

}