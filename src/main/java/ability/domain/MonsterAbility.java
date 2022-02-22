package ability.domain;

public class MonsterAbility extends CommonAbility {
    private MonsterAbility(HealthPoint healthPoint, Power power, Defense defense) {
        super(healthPoint, power, defense);
    }

    public MonsterAbility(MonsterAbility ability) {
        super(ability);
    }

    public static MonsterAbility init(int healthPoint, int power, int defense) {
        return new MonsterAbility(
                new HealthPoint(healthPoint),
                new Power(power),
                new Defense(defense)
        );
    }
}
