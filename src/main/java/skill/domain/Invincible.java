package skill.domain;

import ability.domain.CharacterAbility;
import ability.domain.StatusType;

import java.time.LocalDateTime;

public class Invincible implements Active {
    @Override
    public void action(CharacterAbility ability, long durationSecond) {
        ability.changeStatus(
                StatusType.INVINCIBLE
                , LocalDateTime.now().plusSeconds(durationSecond)
        );
    }
}
