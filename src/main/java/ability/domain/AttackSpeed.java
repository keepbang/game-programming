package ability.domain;

import java.time.LocalDateTime;

public class AttackSpeed extends CommonAbility {
    private double delaySecond;
    private LocalDateTime nextAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        nextAttackTime = LocalDateTime.now();
    }

    public boolean attacked() {
        if (isAttack()) {
            nextAttackTime = LocalDateTime.now()
                    .plusNanos((long) (currentDelaySecond() * 1_000));
            return true;
        }
        return false;
    }

    private boolean isAttack() {
        LocalDateTime current = LocalDateTime.now();
        return nextAttackTime.isBefore(current) || nextAttackTime.isEqual(current);
    }

    public double currentDelaySecond() {
        if (buffPercent < 0) {
            return delaySecond + delaySecond * (Math.abs(buffPercent) / 100.0);
        }
        return Math.round((delaySecond / (buffPercent * 0.01)) * 100) / 100.0;
    }
}
