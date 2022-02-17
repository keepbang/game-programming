package weapon.item;

import ability.domain.Ability;
import character.domain.CharacterType;
import weapon.domain.Weapon;

public class LongSword extends Weapon {
    private static final int ATTACK_PERCENT = 10;

    public LongSword(CharacterType characterType) {
        super(characterType);
    }

    @Override
    public void mount(Ability ability) {
        ability.mountWeapon(ability.getAttack(), ATTACK_PERCENT);
    }

    @Override
    public void unMount(Ability ability) {
        ability.unMountWeapon(ability.getAttack(), ATTACK_PERCENT);
    }
}
