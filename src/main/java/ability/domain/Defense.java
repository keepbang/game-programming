package ability.domain;

public class Defense extends CommonAbility {
    private int defense;

    public Defense(int defense) {
        this.defense = defense;
    }

    public int currentDefense() {
        return defense + defense * buffPercent / 100;
    }
}
