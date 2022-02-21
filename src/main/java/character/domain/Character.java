package character.domain;

import ability.domain.CharacterAbility;
import common.exception.CannotMountWeaponException;
import common.exception.NotFoundSkillException;
import skill.domain.Skill;
import weapon.domain.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {
    private CharacterAbility ability;
    private List<Skill> skills = new ArrayList<>();
    private Weapon weapon;
    private CharacterType characterType;

    public Character(CharacterAbility ability, CharacterType type) {
        this.ability = ability;
        skills.addAll(Skill.getSkill(CharacterType.ALL));
        skills.addAll(Skill.getSkill(type));
        this.characterType = type;
    }

    public CharacterAbility getAbility() {
        return ability;
    }

    public boolean castSkill(Skill castedSkill) {
        Skill skill = skills.stream()
                .filter(castedSkill::equals)
                .findFirst()
                .orElseThrow(NotFoundSkillException::new);

        if (skill.isUltimate() && !ability.isUltimateLevel()) {
            return false;
        }

        if (ability.useMana(skill.getUseMana())) {
            skill.cast(ability);
            return true;
        }

        return false;
    }

    public void mount(Weapon weapon) {
        if (!weapon.getCharacterType().equals(characterType)) {
            throw new CannotMountWeaponException();
        }
        this.weapon = weapon;
        weapon.mount(ability);
    }

    public void unMount() {
        this.weapon.unMount(ability);
        this.weapon = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(ability, character.ability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ability);
    }
}
