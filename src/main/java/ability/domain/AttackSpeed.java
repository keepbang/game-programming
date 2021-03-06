package ability.domain;

import common.util.ValueUtil;

import java.time.LocalDateTime;
import java.util.Objects;

import static common.util.TimeUtil.secondToNanos;

public class AttackSpeed extends BuffAbility {
    private double delaySecond;
    private LocalDateTime nextAttackTime;

    public AttackSpeed(double delaySecond) {
        this.delaySecond = delaySecond;
        nextAttackTime = LocalDateTime.MIN;
    }

    public void increaseByDelay() {
        nextAttackTime = LocalDateTime.now()
                .plusNanos(secondToNanos(currentDelaySecond()));
    }

    public boolean nextAttack() {
        LocalDateTime current = LocalDateTime.now();
        return nextAttackTime.isBefore(current) || nextAttackTime.isEqual(current);
    }

    public double currentDelaySecond() {
        return ValueUtil.round(calcBuffedSecond(), 2);
    }

    private double calcBuffedSecond() {
        int percent = getBuffPercent();
        if (percent <= 0) {
            return delaySecond + (delaySecond * (Math.abs(percent) / 100.0));
        }
        return delaySecond / calcHitCount(percent);
    }

    private double calcHitCount(int percent) {
        return (1.0 + (1.0 * percent / 100.0));
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
