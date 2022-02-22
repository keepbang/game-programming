package character.service;

import ability.domain.CharacterAbility;
import character.domain.Character;
import common.exception.WrongCharacterTypeException;
import common.util.RandomRateGenerator;
import monster.domain.Monster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import skill.domain.*;
import weapon.domain.Weapon;
import weapon.item.*;

import java.util.stream.Stream;

import static ability.domain.CharacterAbilityTest.testCharacterAbility;
import static ability.domain.MonsterAbilityTest.testMonsterAbility;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CharacterServiceTest {

    private final CharacterService service = new CharacterService(RandomRateGenerator.getInstance());

    @ParameterizedTest
    @ValueSource(strings = {
            "", "people", "elff"
    })
    @DisplayName("캐릭터 생성 실패")
    public void createCharacterFail(String type) {
        // given
        CharacterAbility ability = testCharacterAbility();
        // when
        // then
        assertThatThrownBy(() -> service.createCharacter(type, ability))
                .isInstanceOf(WrongCharacterTypeException.class);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("종족에 맞지 않는 무기를 장착 할 경우")
    public void notMountOtherRaceWeapon(String type, Weapon weapon) {
        // given
        Character character = service.createCharacter(type, testCharacterAbility());
        // when
        boolean isMount = service.mount(character, weapon);
        // then
        assertThat(isMount).isFalse();
    }

    private Stream<Arguments> notMountOtherRaceWeapon() {
        return Stream.of(
                Arguments.of("human", new ShortBow()),
                Arguments.of("human", new ShortAxe()),
                Arguments.of("elf", new ShortSword()),
                Arguments.of("elf", new ShortAxe()),
                Arguments.of("orc", new ShortSword()),
                Arguments.of("orc", new ShortBow())
        );
    }

    @Test
    @DisplayName("공격에 실패 했을 경우")
    public void characterAttackFail() {
        // given
        Character character = service.createCharacter("human", testCharacterAbility());
        Monster monster = new Monster(testMonsterAbility());
        // when
        service.attack(character, monster);
        // 공격 후 딜레이로 false 반환
        boolean actual = service.attack(character, monster);
        // then
        assertThat(actual).isFalse();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("종족에 맞지 않는 스킬을 사용했을 경우")
    public void notCastSkillOtherRace(String type, Skill castedSkill) {
        // given
        Character character = service.createCharacter(type, testCharacterAbility());
        // when
        boolean isCast = service.cast(character, castedSkill);
        // then
        assertThat(isCast).isFalse();
    }

    private Stream<Arguments> notCastSkillOtherRace() {
        return Stream.of(
                Arguments.of("human", Skill.ELUSION),
                Arguments.of("orc", Skill.GUARD),
                Arguments.of("elf", Skill.ANGER)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("레벨이 99가 아닐때 궁극스킬을 사용 했을 경우")
    public void notCastUltimateSkill(String type, Skill castedSkill) {
        // given
        Character character = service.createCharacter(type, testCharacterAbility());
        // when
        boolean isCast = service.cast(character, castedSkill);
        // then
        assertThat(isCast).isFalse();
    }

    private Stream<Arguments> notCastUltimateSkill() {
        return Stream.of(
                Arguments.of("human", Skill.INVINCIBLE),
                Arguments.of("orc", Skill.FRENZY),
                Arguments.of("elf", Skill.RAPID)
        );
    }

}