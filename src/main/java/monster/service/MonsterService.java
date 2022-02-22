package monster.service;

import ability.domain.MonsterAbility;
import character.domain.Character;
import common.util.RandomRateGenerator;
import monster.domain.Monster;

public class MonsterService {
    private final RandomRateGenerator rateGenerator;

    public MonsterService() {
        this.rateGenerator = RandomRateGenerator.getInstance();
    }
    /**
     * 몬스터 생성
     */
    public Monster createMonster(MonsterAbility ability) {
        return new Monster(ability);
    }

    /**
     * 몬스터 공격
     * - 캐릭터의 회피율에 따라 공격을 회피한다.
     */
    public boolean attack(Character character, Monster monster) {
        if (character.isAvoid(rateGenerator)) {
            return false;
        }
        return monster.attack(character);
    }
}
