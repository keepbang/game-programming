package ability.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AvoidRateTest {

    private static final int DEFAULT_AVOID_RATE = 50;

    @ParameterizedTest
    @CsvSource(value = {
            "49,true", "51, false"
    })
    @DisplayName("회피 할 수 있는지 확인")
    public void isAvoid(int rate, boolean avoid) {
        // given
        AvoidRate avoidRate = new AvoidRate(DEFAULT_AVOID_RATE);
        // when
        boolean actual = avoidRate.isAvoid(() -> rate);
        // then
        assertThat(actual).isEqualTo(avoid);
    }
}
