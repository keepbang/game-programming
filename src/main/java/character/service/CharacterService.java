package character.service;

import ability.domain.CharacterAbility;
import character.domain.Character;
import character.domain.CharacterRace;
import common.exception.CannotMountWeaponException;
import common.util.RandomRateGenerator;
import monster.domain.Monster;
import weapon.domain.Weapon;

public class CharacterService {
    private final RandomRateGenerator rateGenerator;

    public CharacterService() {
        this.rateGenerator = RandomRateGenerator.getInstance();
    }

    /**
     * 캐릭터 생성
     */
    public Character createCharacter(String type, CharacterAbility ability) {
        return CharacterRace.generateCharacter(type, ability);
    }

    /**
     * 캐릭터 무기 장착
     */
    public boolean mount(Character character, Weapon weapon) {
        try {
            character.mount(weapon);
            return true;
        } catch (CannotMountWeaponException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 캐릭터 공격
     * - 일정 확률로 캐릭터가 몬스터의 반격 대미지를 받을 수 있다.
     * @return 공격 성공 여부
     */
    public boolean attack(Character character, Monster monster) {
        boolean isAttack = character.attack(monster);
        if (isAttack) {
            character.downHp(monster.counterDamage(rateGenerator));
        }
        return isAttack;
    }
}
