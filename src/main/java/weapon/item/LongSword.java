package weapon.item;

import ability.domain.CharacterAbility;
import character.domain.CharacterType;
import weapon.domain.Weapon;

public class LongSword extends Weapon {
    private static final int ATTACK_PERCENT = 10;

    public LongSword() {
        super(CharacterType.HUMAN);
    }

    @Override
    public void mount(CharacterAbility ability) {
        ability.mountWeapon(ability.getPower(), ATTACK_PERCENT);
    }

    @Override
    public void unMount(CharacterAbility ability) {
        ability.unMountWeapon(ability.getPower(), ATTACK_PERCENT);
    }
}
