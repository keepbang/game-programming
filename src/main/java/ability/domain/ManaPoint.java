package ability.domain;

public class ManaPoint {
    private final int maxManaPoint;
    private int manaPoint;

    public ManaPoint(int manaPoint) {
        this.manaPoint = manaPoint;
        this.maxManaPoint = manaPoint;
    }

    public void healMana(int healPoint) {
        this.manaPoint = remainManaPoint(manaPoint + healPoint);
    }

    private int remainManaPoint(int remain) {
        return Math.min(remain, maxManaPoint);
    }

    public boolean useMana(int usedMana) {
        if (isMana(usedMana)) {
            manaPoint -= usedMana;
            return true;
        }
        return false;
    }

    private boolean isMana(int usedMana) {
        return this.manaPoint >= usedMana;
    }

    public int getCurrentMp() {
        return manaPoint;
    }
}
