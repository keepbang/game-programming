package skill.domain;

import ability.domain.CharacterAbility;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class GuardTest {

    @Test
    @DisplayName("휴먼 스킬 사용 : 방어력 30% 상승")
    public void guard() {
        // given
        Character human = makeCharacter("human");
        // when
        boolean isUsedSkill = human.castSkill(Skill.GUARD);
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(human.currentDefense()).isEqualTo(13);
    }

}