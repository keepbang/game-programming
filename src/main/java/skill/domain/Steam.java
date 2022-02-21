package skill.domain;

import ability.domain.Ability;

public final class Steam implements Active {
    private static final int ATTACK_UP = 20;

    @Override
    public void action(Ability ability, long durationSecond) {
        ability.powerBuff(ATTACK_UP, durationSecond);
    }
}
