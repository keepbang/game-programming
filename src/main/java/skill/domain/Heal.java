package skill.domain;

import ability.domain.CharacterAbility;

public final class Heal implements Active {
    private static final int HEAL_POINT = 50;

    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.upHp(HEAL_POINT);
    }
}
