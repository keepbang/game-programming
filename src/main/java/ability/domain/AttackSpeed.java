package ability.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import static common.util.TimeUtil.secondToNanos;

public class AttackSpeed extends CommonAbility {
    private double delaySecond;
    private LocalDateTime nextAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        nextAttackTime = LocalDateTime.MIN;
    }

    public boolean increaseByDelay() {
        if (isAttack()) {
            nextAttackTime = LocalDateTime.now()
                    .plusNanos(secondToNanos(currentDelaySecond()));
            return true;
        }
        return false;
    }

    private boolean isAttack() {
        LocalDateTime current = LocalDateTime.now();
        return nextAttackTime.isBefore(current) || nextAttackTime.isEqual(current);
    }

    public double currentDelaySecond() {
        int percent = getBuffPercent();
        return Math.round(calcBuffedSecond(percent) * 100) / 100.0;
    }

    private double calcBuffedSecond(int percent) {
        if (percent <= 0) {

            return delaySecond + (delaySecond * (Math.abs(percent) / 100.0));
        }
        return delaySecond / calcHitCount(percent);
    }

    private double calcHitCount(int percent) {
        return (1.0 +  (1.0 * percent / 100.0));
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
