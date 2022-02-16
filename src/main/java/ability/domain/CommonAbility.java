package ability.domain;

import java.time.LocalDateTime;

public class CommonAbility {
    protected int buff = 0;
    protected LocalDateTime unlockBuffTime = LocalDateTime.now();

    public void changeBuff(int percent, long durationSecond) {
        this.buff = percent;
        this.unlockBuffTime = LocalDateTime.now()
                .plusSeconds(durationSecond);
    }
}
