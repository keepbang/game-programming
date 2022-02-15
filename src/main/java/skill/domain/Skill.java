package skill.domain;

import ability.domain.Ability;
import ability.domain.ManaPoint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Skill {
    HEAL(SkillRace.ALL, new ManaPoint(15), new Heal(), false),
    STEAM(SkillRace.ALL, new ManaPoint(10), new Steam(), false),
    GUARD(SkillRace.HUMAN, new ManaPoint(20), new Guard(), false),
    ELUSION(SkillRace.ELF, new ManaPoint(20), new Elusion(), false),
    Anger(SkillRace.ORC, new ManaPoint(20), new Anger(), false),

    /**
     * 궁극 스킬
     */
    INVINCIBLE(SkillRace.HUMAN, new ManaPoint(50), new Invincible(), true),
    RAPID(SkillRace.ELF, new ManaPoint(50), new Rapid(), true),
    FRENZY(SkillRace.ORC, new ManaPoint(50), new Frenzy(), true);

    private final SkillRace race;
    private final ManaPoint useMana;
    private final Active active;
    private final boolean ultimate;

    Skill(SkillRace race, ManaPoint useMana, Active active, boolean ultimate) {
        this.race = race;
        this.useMana = useMana;
        this.active = active;
        this.ultimate = ultimate;
    }

    public static List<Skill> getSkill(SkillRace race) {
        return Arrays.stream(values())
                .filter(skill -> skill.race.equals(race))
                .collect(Collectors.toList());
    }

    public void cast(Ability ability) {
        active.action(ability);
    }

    public ManaPoint getUseMana() {
        return useMana;
    }

    public boolean isUltimate() {
        return ultimate;
    }
}
