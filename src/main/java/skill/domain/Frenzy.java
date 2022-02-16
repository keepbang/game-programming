package skill.domain;

import ability.domain.Ability;

public class Frenzy implements Active {
    private static final int ATTACK_UP = 500;

    @Override
    public void action(Ability ability, long durationSecond) {
        ability.attackBuff(ATTACK_UP, durationSecond);
    }
}
