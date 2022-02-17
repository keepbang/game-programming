package ability.domain;

import java.time.LocalDateTime;

public class CommonAbility {
    private int buffPercent = 0;
    private LocalDateTime unlockBuffTime = LocalDateTime.MIN;
    private int weaponBuffPercent = 0;

    public void changeBuff(int percent, long durationSecond) {
        this.buffPercent = percent;
        this.unlockBuffTime = LocalDateTime.now()
                .plusSeconds(durationSecond);
    }

    public int getBuffPercent() {
        return buffPercent + weaponBuffPercent;
    }

    public void mountWeapon(int percent) {
        this.weaponBuffPercent += percent;
    }

    public void unMountWeapon(int percent) {
        this.weaponBuffPercent -= percent;
    }
}
