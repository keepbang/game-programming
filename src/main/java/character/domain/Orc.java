package character.domain;

import ability.domain.Ability;
import skill.domain.SkillRace;

public class Orc extends Character {
    public Orc(Ability ability) {
        super(ability, SkillRace.ORC);
    }
}
