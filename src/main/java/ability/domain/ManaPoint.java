package ability.domain;

public class ManaPoint {
    private int manaPoint;

    public ManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
    }

    public boolean isMana(int usedMana) {
        return this.manaPoint >= usedMana;
    }
}
