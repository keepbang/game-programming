package ability.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelTest {

    @Test
    @DisplayName("레벨 업")
    public void levelUpTest() {
        // given
        Level level = new Level();
        // when
        level.levelUp();
        // then
        assertThat(level).isEqualTo(new Level(2));
    }

}