package skill.domain;

import ability.domain.CharacterAbility;

public final class Anger implements Active {
    private static final int ATTACK_UP = 50;
    private static final int DEFENSE_DOWN = -10;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.powerBuff(ATTACK_UP, durationSecond);
        ability.defenseBuff(DEFENSE_DOWN, durationSecond);
    }
}
