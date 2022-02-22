import ability.domain.CharacterAbility;
import ability.domain.MonsterAbility;
import character.domain.Character;
import character.domain.CharacterRace;
import character.service.CharacterService;
import monster.domain.Monster;
import monster.service.MonsterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import skill.domain.Skill;
import weapon.domain.Weapon;
import weapon.item.LongSword;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegratedTest {

    private final CharacterService characterService = new CharacterService(() -> 29);
    private final MonsterService monsterService = new MonsterService(() -> 51);

    @Test
    @DisplayName("게임 테스트")
    public void gameTest() throws InterruptedException {
        // given
        String characterType = "human";
        Weapon weapon = new LongSword();
        Skill skill = Skill.GUARD;

        // 캐릭터 생성
        CharacterAbility characterAbility = CharacterAbility.init(1, 100, 100, 50, 1, 10, 50);
        Character character = characterService.createCharacter(characterType, characterAbility);
        assertThat(character).isEqualTo(CharacterRace.generateCharacter(characterType, characterAbility));
        // 몬스터 생성
        MonsterAbility monsterAbility = MonsterAbility.init(100, 20, 1);
        Monster monster = monsterService.createMonster(monsterAbility);
        assertThat(monster).isEqualTo(new Monster(monsterAbility));
        // 캐릭터 무기 장착
        boolean isMount = characterService.mount(character, weapon);
        assertThat(isMount).isTrue();
        assertThat(character.currentPower()).isEqualTo(55);
        // 캐릭터 스킬 사용
        boolean isCast = characterService.cast(character, skill);
        assertThat(isCast).isTrue();
        assertThat(character.currentDefense()).isEqualTo(13);
        // 캐릭터 공격
        boolean characterAttack = characterService.attack(character, monster);
        assertThat(characterAttack).isTrue();
        assertThat(monster.currentHp()).isEqualTo(46);
        // 몬스터의 반격으로 인한 대미지
        assertThat(character.currentHp()).isEqualTo(99);
        // 몬스터 공격
        boolean monsterAttack = monsterService.attack(character, monster);
        assertThat(monsterAttack).isTrue();
        assertThat(character.currentHp()).isEqualTo(92);
        // 레벨업을 위해 몬스터를 죽임(공격 후 대기시간 적용)
        Thread.sleep(1_000);
        boolean isAttack = characterService.attack(character, monster);
        assertThat(isAttack).isFalse();
        // 캐릭터 레벨업
        boolean isLevelUp = characterService.levelUp(character, monster);
        assertThat(isLevelUp).isTrue();
    }
}
