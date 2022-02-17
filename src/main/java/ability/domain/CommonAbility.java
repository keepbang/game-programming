package ability.domain;

import java.time.LocalDateTime;

public class CommonAbility {
    protected int buffPercent = 0;
    protected LocalDateTime unlockBuffTime = LocalDateTime.now();
    protected int weaponBuffPercent = 0;

    public void changeBuff(int percent, long durationSecond) {
        this.buffPercent = percent;
        this.unlockBuffTime = LocalDateTime.now()
                .plusSeconds(durationSecond);
    }

    public void mountWeapon(int percent) {
        this.weaponBuffPercent += percent;
    }

    public void unMountWeapon(int percent) {
        this.weaponBuffPercent -= percent;
    }
}
