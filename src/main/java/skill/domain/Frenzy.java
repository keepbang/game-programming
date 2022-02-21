package skill.domain;

import ability.domain.CharacterAbility;

public class Frenzy implements Active {
    private static final int ATTACK_UP = 500;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.powerBuff(ATTACK_UP, durationSecond);
    }
}
