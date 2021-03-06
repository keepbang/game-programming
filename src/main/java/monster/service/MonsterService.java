package monster.service;

import ability.domain.MonsterAbility;
import ability.domain.StatusType;
import character.domain.Character;
import common.util.Rate;
import monster.domain.Monster;

public class MonsterService {
    private final Rate rateGenerator;

    public MonsterService(Rate rate) {
        this.rateGenerator = rate;
    }

    /**
     * 몬스터 생성
     */
    public Monster createMonster(MonsterAbility ability) {
        return new Monster(ability);
    }

    /**
     * 몬스터 공격
     * - 캐릭터는 회피율에 따라 공격을 회피한다.
     * - 캐릭터가 무적일 경우 공격을 받지 않는다.
     */
    public boolean attack(Character character, Monster monster) {
        if (character.isAvoid(rateGenerator)) {
            return false;
        }
        if (character.currentStatus().equals(StatusType.INVINCIBLE)) {
            return false;
        }
        return monster.attack(character);
    }
}
