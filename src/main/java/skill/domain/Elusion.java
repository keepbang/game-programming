package skill.domain;

import ability.domain.Ability;

public final class Elusion implements Active {
    private static final int AVOID_UP = 30;

    @Override
    public void action(Ability ability, long durationSecond) {
        ability.avoidBuff(AVOID_UP, durationSecond);
    }
}
