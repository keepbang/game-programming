package monster.domain;

import ability.domain.CommonAbility;
import ability.domain.MonsterAbility;
import action.Attack;
import common.util.Rate;

public class Monster extends MonsterAbility implements CounterAttack, Attack {
    private static final int COUNTER_RATE = 30;
    private static final double COUNTER_DAMAGE_PERCENT = 0.7;

    public Monster(MonsterAbility ability) {
        super(ability);
    }

    /**
     * 반격
     * - 확률이 30이하라면 대미지를 계산해서 반환한다.
     * - 확률이 30보다 클 경우에는 0을 반환한다.
     */
    @Override
    public double counterDamage(Rate rate) {
        if (COUNTER_RATE >= rate.getRate()) {
            return currentPower() * COUNTER_DAMAGE_PERCENT;
        }
        return 0;
    }

    @Override
    public boolean attack(CommonAbility target) {
        target.downHp(currentPower());
        return target.isDie();
    }
}
