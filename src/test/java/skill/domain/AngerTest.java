package skill.domain;

import ability.domain.CharacterAbility;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class AngerTest {

    @Test
    @DisplayName("오크 스킬 사용 : 공격력 30% 증가, 방어력 10% 하락")
    public void anger() {
        // given
        Character orc = makeCharacter("orc");
        // when
        boolean isUsedSkill = orc.castSkill(Skill.ANGER);
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(orc.currentPower()).isEqualTo(15);
        assertThat(orc.currentDefense()).isEqualTo(9);
    }

}