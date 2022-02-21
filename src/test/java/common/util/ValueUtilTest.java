package common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueUtilTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 362.2", "0, 362.0", "-1, 360.0"
    })
    @DisplayName("소수점 자리수 반올림")
    public void roundTest(int squared, double result) {
        double value = 362.186578;
        double roundValue = ValueUtil.round(value, squared);
        assertThat(roundValue).isEqualTo(result);
    }
}