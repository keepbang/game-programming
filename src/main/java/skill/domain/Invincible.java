package skill.domain;

import ability.domain.Ability;
import ability.domain.StatusType;

import java.time.LocalDateTime;

public class Invincible implements Active {
    @Override
    public void action(Ability ability, long durationSecond) {
        ability.changeStatus(
                StatusType.INVINCIBLE
                , LocalDateTime.now().plusSeconds(durationSecond)
        );
    }
}
