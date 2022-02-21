package skill.domain;

import ability.domain.CharacterAbility;

public final class Steam implements Active {
    private static final int ATTACK_UP = 20;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.powerBuff(ATTACK_UP, durationSecond);
    }
}
