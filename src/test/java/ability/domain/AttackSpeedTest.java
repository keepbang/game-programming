package ability.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttackSpeedTest {

    private AttackSpeed attackSpeed;

    @BeforeEach
    public void setUp() {
        attackSpeed = new AttackSpeed(0.5);
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

}