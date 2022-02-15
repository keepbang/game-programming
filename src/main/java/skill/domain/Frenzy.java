package skill.domain;

import ability.domain.Ability;

public class Frenzy implements Active {
    private static final int ATTACK_UP = 500;

    @Override
    public void action(Ability ability) {
        ability.attackBuff(ATTACK_UP);
    }
}
