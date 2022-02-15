package skill.domain;

import ability.domain.Ability;

public final class Heal implements Active {
    private static final int HEAL_POINT = 50;

    @Override
    public void action(Ability ability) {
        ability.upHp(HEAL_POINT);
    }
}
