package monster.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MonsterTest {

    private Monster monster;

    @BeforeEach
    public void setUp() {
        monster = new Monster(100, 10, 10);
    }

    @Test
    @DisplayName("몬스터 생성")
    public void create() {
        assertThat(monster).isEqualTo(new Monster(100, 10, 10));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "29, 7", "30, 7", "31, 0"
    })
    @DisplayName("확률에 따른 반격 대미지")
    public void counterAttackTest(int rate, double counterDamage) {
        // when
        double damage = monster.counterDamage(() -> rate);
        // then
        assertThat(damage).isEqualTo(counterDamage);
    }

}