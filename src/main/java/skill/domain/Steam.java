package skill.domain;

import ability.domain.Ability;

public final class Steam implements Active {
    private static final int ATTACK_UP = 10;

    @Override
    public void action(Ability ability) {
        ability.attackBuff(ATTACK_UP);
    }
}
