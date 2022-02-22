package weapon.domain;

import character.domain.Character;
import common.exception.CannotMountWeaponException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapon.item.*;

import java.util.stream.Stream;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeaponTest {
    private Stream<Arguments> wrongMountWeapon() {
        return Stream.of(
                Arguments.of(makeCharacter("human"), new ShortBow()),
                Arguments.of(makeCharacter("human"), new ShortAxe()),
                Arguments.of(makeCharacter("elf"), new ShortSword()),
                Arguments.of(makeCharacter("elf"), new ShortAxe()),
                Arguments.of(makeCharacter("orc"), new ShortBow()),
                Arguments.of(makeCharacter("orc"), new ShortSword())
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("무기를 잘 못 착용했을 경우")
    public void wrongMountWeapon(Character character, Weapon weapon) {
        assertThatThrownBy(() -> character.mount(weapon))
                .isInstanceOf(CannotMountWeaponException.class);
    }
}
