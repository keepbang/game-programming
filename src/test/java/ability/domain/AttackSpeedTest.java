package ability.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttackSpeedTest {

    private AttackSpeed attackSpeed;

    @BeforeEach
    public void setUp() {
        attackSpeed = new AttackSpeed(1.0);
    }


    @Test
    @DisplayName("공격 성공 후 대기시간동안 공격 불가능")
    public void isAttackFalse() {
        // when
        attackSpeed.increaseByDelay();
        // then
        assertThat(attackSpeed.isAttack()).isFalse();
    }

    @Test
    @DisplayName("공격을 한 후에 대기시간이 지나면 공격을 할 수 있다.")
    public void isAttackTrue() throws InterruptedException {
        // when
        attackSpeed.increaseByDelay();
        Thread.sleep(1_000);
        // then
        assertThat(attackSpeed.isAttack()).isTrue();
    }

    @Test
    @DisplayName("버프 받은 후 현재 공격속도 검증")
    public void attackSpeedUp() {
        // given
        // when
        attackSpeed.changeBuff(500, 10);
        // then
        assertThat(attackSpeed.currentDelaySecond()).isEqualTo(0.17);
    }

    @Test
    @DisplayName("공격속도가 낮아지면 공격 후 딜레이는 증가한다.")
    public void attackSpeedDown() {
        // given
        // when
        attackSpeed.changeBuff(-15, 10);
        // then
        assertThat(attackSpeed.currentDelaySecond()).isEqualTo(1.15);
    }
}