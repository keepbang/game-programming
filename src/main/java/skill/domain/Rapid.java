package skill.domain;

import ability.domain.Ability;

public final class Rapid implements Active {
    private static final int ATTACK_SPEED_UP = 500;

    @Override
    public void action(Ability ability, long durationSecond) {
        ability.attackSpeedBuff(ATTACK_SPEED_UP, durationSecond);
    }
}
