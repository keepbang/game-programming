package skill.domain;

import ability.domain.CharacterAbility;

public final class Guard implements Active {
    private static final int DEFENSE_UP = 30;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.defenseBuff(DEFENSE_UP, durationSecond);
    }
}
