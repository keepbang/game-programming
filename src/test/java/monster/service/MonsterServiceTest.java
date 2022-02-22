package monster.service;

import ability.domain.CharacterAbility;
import character.domain.Character;
import character.domain.CharacterRace;
import monster.domain.Monster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import skill.domain.Skill;

import static ability.domain.MonsterAbilityTest.testMonsterAbility;
import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

public class MonsterServiceTest {

    @ParameterizedTest
    @CsvSource(value = {
            "49, false", "50, false", "51, true"
    })
    @DisplayName("몬스터가 공격할 때 캐릭터의 회피율에 따라 공격이 무시될 수 있다.")
    public void monsterAttackTest(int rate, boolean result) {
        // given
        MonsterService monsterService = new MonsterService(() -> rate);
        Character character = makeCharacter("human");
        Monster monster = monsterService.createMonster(testMonsterAbility());
        // when
        boolean actual = monsterService.attack(character, monster);
        // then
        assertThat(actual).isEqualTo(result);
    }

    @Test
    @DisplayName("휴먼 캐릭터가 무적 스킬을 사용하면 공격이 실패한다.")
    public void monsterAttackFailByInvincibleCharacter() {
        // given
        MonsterService monsterService = new MonsterService(() -> 50);
        CharacterAbility characterAbility = CharacterAbility.init(99, 100, 100, 50, 1, 10, 50);
        Character character = CharacterRace.generateCharacter("human", characterAbility);
        Monster monster = monsterService.createMonster(testMonsterAbility());
        // when
        character.castSkill(Skill.INVINCIBLE);
        boolean actual = monsterService.attack(character, monster);
        // then
        assertThat(actual).isFalse();
    }
}