package ability.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthPointTest {

    private static final int DEFAULT_HP = 100;

    @ParameterizedTest
    @CsvSource(value = {
            "0,100", "50,50", "101,0"
    })
    @DisplayName("hp down 테스트")
    public void downHpTest(int damage, int remain) {
        // given
        HealthPoint healthPoint = new HealthPoint(DEFAULT_HP);
        // when
        healthPoint.downHp(damage);
        // then
        assertThat(healthPoint.getCurrentHp()).isEqualTo(remain);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "50,100", "51,100"
    })
    @DisplayName("hp up 테스트")
    public void healHPTest(int healPoint, int remain) {
        // given
        HealthPoint healthPoint = new HealthPoint(DEFAULT_HP);
        healthPoint.downHp(50);
        // when
        healthPoint.healHp(healPoint);
        // then
        assertThat(healthPoint.getCurrentHp()).isEqualTo(remain);
    }
}