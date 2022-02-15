package ability.domain;

public class Attack extends CommonAbility {
    private int attack;

    public Attack(int attack) {
        this.attack = attack;
    }

    public int currentAttack() {
        return attack + attack * buff / 100;
    }
}
