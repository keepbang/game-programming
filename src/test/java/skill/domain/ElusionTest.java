package skill.domain;

import ability.domain.Ability;
import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class ElusionTest {

    @Test
    @DisplayName("엘프 스킬 사용 : 회피력 30% 상승")
    public void elusion() {
        // given
        Character elf = makeCharacter("elf");
        // when
        boolean isUsedSkill = elf.castSkill(Skill.ELUSION);
        Ability ability = elf.getAbility();
        // then
        assertThat(isUsedSkill).isTrue();
        assertThat(ability.currentAvoidRate()).isEqualTo(65);
    }
}