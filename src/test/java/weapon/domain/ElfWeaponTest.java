package weapon.domain;

import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapon.item.IronBow;
import weapon.item.ShortBow;

import java.util.stream.Stream;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ElfWeaponTest {
    private Stream<Arguments> mountWeapon() {
        return Stream.of(
                Arguments.of(makeCharacter("elf"), new ShortBow(), 0.67),
                Arguments.of(makeCharacter("elf"), new IronBow(), 0.64)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("엘프 무기 장착 후 공격력 검증")
    public void mountWeapon(Character character, Weapon weapon, double attackDelay) {
        // given
        assertThat(character.getAbility().currentAttackSpeed()).isEqualTo(0.7);
        // when
        character.mount(weapon);
        // then
        assertThat(character.getAbility().currentAttackSpeed()).isEqualTo(attackDelay);
    }
}
