package ability.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class AttackSpeed extends CommonAbility {
    private double delaySecond;
    private LocalDateTime nextAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        nextAttackTime = LocalDateTime.MIN;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttackSpeed that = (AttackSpeed) o;
        return Double.compare(that.delaySecond, delaySecond) == 0
                && Objects.equals(nextAttackTime, that.nextAttackTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delaySecond, nextAttackTime);
    }
}
