package character.domain;

import ability.domain.Ability;
import ability.domain.StatusType;
import common.exception.NotFoundSkillException;
import skill.domain.Skill;
import skill.domain.SkillRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Character {
    private Ability ability;
    private List<Skill> skills = new ArrayList<>();

    public Character(Ability ability, SkillRace race) {
        this.ability = ability;
        skills.addAll(Skill.getSkill(SkillRace.ALL));
        skills.addAll(Skill.getSkill(race));
    }

    public Ability getAbility() {
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
