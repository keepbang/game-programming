package skill.domain;

import ability.domain.Ability;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.CharacterTest.generateTestCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class AngerTest {

    @Test
    @DisplayName("오크 스킬 사용 : 공격력 30% 증가, 방어력 10% 하락")
    public void anger() {
        // given
        Character orc = generateTestCharacter("orc");
        // when
        boolean isUsedSkill = orc.castSkill(Skill.ANGER);
        Ability ability = orc.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentAttack()).isEqualTo(15);
        assertThat(ability.currentDefense()).isEqualTo(9);
    }

}