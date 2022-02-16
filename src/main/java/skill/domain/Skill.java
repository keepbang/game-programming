package skill.domain;

import ability.domain.Ability;
import ability.domain.ManaPoint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Skill {
    HEAL(SkillRace.ALL, new ManaPoint(15), new Heal(), false, 0),
    STEAM(SkillRace.ALL, new ManaPoint(10), new Steam(), false, 5),
    GUARD(SkillRace.HUMAN, new ManaPoint(20), new Guard(), false, 10),
    ELUSION(SkillRace.ELF, new ManaPoint(20), new Elusion(), false, 10),
    ANGER(SkillRace.ORC, new ManaPoint(20), new Anger(), false, 10),

    /**
     * 궁극 스킬
     */
    INVINCIBLE(SkillRace.HUMAN, new ManaPoint(50), new Invincible(), true, 10),
    RAPID(SkillRace.ELF, new ManaPoint(50), new Rapid(), true, 60),
    FRENZY(SkillRace.ORC, new ManaPoint(50), new Frenzy(), true, 60);

    private final SkillRace race;
    private final ManaPoint useMana;
    private final Active active;
    private final boolean ultimate;
    private final long durationSecond;

    Skill(SkillRace race, ManaPoint useMana, Active active, boolean ultimate, long durationSecond) {
        this.race = race;
        this.useMana = useMana;
        this.active = active;
        this.ultimate = ultimate;
        this.durationSecond = durationSecond;
    }

    public static List<Skill> getSkill(SkillRace race) {
        return Arrays.stream(values())
                .filter(skill -> skill.race.equals(race))
                .collect(Collectors.toList());
    }

    public void cast(Ability ability) {
        active.action(ability, durationSecond);
    }

    public ManaPoint getUseMana() {
        return useMana;
    }

    public boolean isUltimate() {
        return ultimate;
    }
}
