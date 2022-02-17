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
    @DisplayName("공격 성공")
    public void attackSuccess() {
        // when
        boolean actual = attackSpeed.attacked();
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("공격을 한 후에 대기시간동안은 공격을 할 수 없다.")
    public void attackFail() {
        // when
        attackSpeed.attacked();
        boolean actual = attackSpeed.attacked();
        // then
        assertThat(actual).isFalse();
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