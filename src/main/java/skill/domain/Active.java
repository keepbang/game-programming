package skill.domain;

import ability.domain.CharacterAbility;

public interface Active {
    void action(CharacterAbility ability, long durationSecond);
}
