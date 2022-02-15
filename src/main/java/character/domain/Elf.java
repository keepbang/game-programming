package character.domain;

import ability.domain.Ability;
import skill.domain.SkillRace;

public class Elf extends Character {
    public Elf(Ability ability) {
        super(ability, SkillRace.ELF);
    }
}
