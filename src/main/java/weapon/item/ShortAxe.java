package weapon.item;

import ability.domain.Ability;
import character.domain.CharacterType;
import weapon.domain.Weapon;

public class ShortAxe extends Weapon {
    private static final int ATTACK_PERCENT = 10;
    private static final int ATTACK_SPEED_PERCENT = -5;

    public ShortAxe() {
        super(CharacterType.ORC);
    }

    @Override
    public void mount(Ability ability) {
        ability.mountWeapon(ability.getPower(), ATTACK_PERCENT);
        ability.mountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }

    @Override
    public void unMount(Ability ability) {
        ability.unMountWeapon(ability.getPower(), ATTACK_PERCENT);
        ability.unMountWeapon(ability.getAttackSpeed(), ATTACK_SPEED_PERCENT);
    }
}
