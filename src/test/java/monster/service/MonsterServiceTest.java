package monster.service;

import character.domain.Character;
import monster.domain.Monster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}