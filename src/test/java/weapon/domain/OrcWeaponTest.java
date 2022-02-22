package weapon.domain;

import character.domain.Character;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import weapon.item.IronHammer;
import weapon.item.ShortAxe;

import java.util.stream.Stream;

import static character.domain.CharacterTest.makeCharacter;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrcWeaponTest {
    private Stream<Arguments> mountWeapon() {
        return Stream.of(
                Arguments.of(makeCharacter("orc"), new ShortAxe(), 11.0, 0.74),
                Arguments.of(makeCharacter("orc"), new IronHammer(), 12.0, 0.77)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("오크 무기 장착 후 공격력 검증")
    public void mountWeapon(Character character, Weapon weapon, double attack, double attackSpeed) {
        // given
        assertThat(character.currentPower()).isEqualTo(10);
        assertThat(character.currentAttackSpeed()).isEqualTo(0.7);
        // when
        character.mount(weapon);
        // then
        assertThat(character.currentPower()).isEqualTo(attack);
        assertThat(character.currentAttackSpeed()).isEqualTo(attackSpeed);
    }
}
