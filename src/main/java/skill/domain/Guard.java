package skill.domain;

import ability.domain.Ability;

public final class Guard implements Active {
    private static final int DEFENSE_UP = 30;

    @Override
    public void action(Ability ability, long durationSecond) {
        ability.defenseBuff(DEFENSE_UP, durationSecond);
    }
}
