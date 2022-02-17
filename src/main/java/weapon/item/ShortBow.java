package weapon.item;

import ability.domain.Ability;
import character.domain.CharacterType;
import weapon.domain.Weapon;

public class ShortBow extends Weapon {
    private static final int ATTACK_SPEED_PERCENT = 5;

    public ShortBow() {
        super(CharacterType.ELF);
    }

    @Override
    public void mount(Ability ability) {
        ability.mountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }

    @Override
    public void unMount(Ability ability) {
        ability.unMountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }
}
