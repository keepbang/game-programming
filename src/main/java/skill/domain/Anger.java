package skill.domain;

import ability.domain.Ability;

public final class Anger implements Active {
    private static final int ATTACK_UP = 50;
    private static final int DEFENSE_DOWN = -10;

    @Override
    public void action(Ability ability) {
        ability.attackBuff(ATTACK_UP);
        ability.defenseBuff(DEFENSE_DOWN);
    }
}
