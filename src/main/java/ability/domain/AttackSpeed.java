package ability.domain;

import java.time.LocalDateTime;

public class AttackSpeed extends CommonAbility {
    private double delaySecond;
    private LocalDateTime lastAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        lastAttackTime = LocalDateTime.now();
    }

    public boolean attacked() {
        if (isAttack()) {
            lastAttackTime = LocalDateTime.now()
                    .plusNanos((long) (currentDelaySecond() * 1_000));
            return true;
        }
        return false;
    }

    private boolean isAttack() {
        LocalDateTime current = LocalDateTime.now();
        return lastAttackTime.isBefore(current) || lastAttackTime.isEqual(current);
    }

    public double currentDelaySecond() {
        if (buff < 0) {
            return delaySecond + delaySecond * (Math.abs(buff) / 100.0);
        }
        return Math.round((delaySecond / (buff * 0.01)) * 100) / 100.0;
    }
}
