package character.domain;

import ability.domain.Ability;
import skill.domain.SkillRace;

public class Human extends Character {
    public Human(Ability ability) {
        super(ability, SkillRace.HUMAN);
    }
}
