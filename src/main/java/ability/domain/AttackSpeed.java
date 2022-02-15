package ability.domain;

import java.time.LocalDateTime;

public class AttackSpeed {
    private double delaySecond;
    private LocalDateTime lastAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        lastAttackTime = LocalDateTime.now();
    }

    public boolean attacked() {
        if (isAttack()) {
            lastAttackTime = LocalDateTime.now()
                    .plusNanos((long) (delaySecond * 1_000));
            return true;
        }
        return false;
    }

    private boolean isAttack() {
        LocalDateTime current = LocalDateTime.now();
        return lastAttackTime.isBefore(current) || lastAttackTime.isEqual(current);
    }
}
