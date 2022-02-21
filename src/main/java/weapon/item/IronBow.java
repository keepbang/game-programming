package weapon.item;

import ability.domain.CharacterAbility;
import character.domain.CharacterType;
import weapon.domain.Weapon;

public class IronBow extends Weapon {
    private static final int ATTACK_SPEED_PERCENT = 10;

    public IronBow() {
        super(CharacterType.ELF);
    }

    @Override
    public void mount(CharacterAbility ability) {
        ability.mountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }

    @Override
    public void unMount(CharacterAbility ability) {
        ability.unMountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }
}
