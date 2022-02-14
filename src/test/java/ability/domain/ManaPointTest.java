package ability.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ManaPointTest {

    @ParameterizedTest
    @CsvSource(value = {
            "100, 101", "0, 1",
    })
    @DisplayName("스킬 사용시 필요한 마나보다 적거나 0이 되면 스킬을 사용 할 수 없다.")
    public void isManaFalse(int currentMana, int usedMana) {
        // then
        assertThat(isManaTest(currentMana, usedMana)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100, 99", "0, 0", "100, 100"
    })
    @DisplayName("마나를 사용할 수 있을 경우")
    public void isMansTrue(int currentMana, int usedMana) {
        // then
        assertThat(isManaTest(currentMana, usedMana)).isTrue();
    }

    private boolean isManaTest(int currentMana, int usedMana) {
        // given
        ManaPoint manaPoint = new ManaPoint(currentMana);
        // when
        return manaPoint.isMana(usedMana);
    }

}
