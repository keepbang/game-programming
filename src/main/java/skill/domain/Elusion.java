package skill.domain;

import ability.domain.CharacterAbility;

public final class Elusion implements Active {
    private static final int AVOID_UP = 30;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.avoidBuff(AVOID_UP, durationSecond);
    }
}
