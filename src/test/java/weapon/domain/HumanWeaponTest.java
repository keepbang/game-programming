package weapon.domain;

import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapon.item.LongSword;
import weapon.item.ShortSword;

import java.util.stream.Stream;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HumanWeaponTest {
    private Stream<Arguments> mountWeapon() {
        return Stream.of(
                Arguments.of(makeCharacter("human"), new ShortSword(), 10.5),
                Arguments.of(makeCharacter("human"), new LongSword(), 11.0)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("휴먼 무기 장착 후 공격력 검증")
    public void mountWeapon(Character character, Weapon weapon, double attack) {
        // given
        assertThat(character.getAbility().currentPower()).isEqualTo(10);
        // when
        character.mount(weapon);
        // then
        assertThat(character.getAbility().currentPower()).isEqualTo(attack);
    }
}
