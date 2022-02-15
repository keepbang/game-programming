package ability.domain;

public class CommonAbility {
    protected int buff = 0;

    public void changeBuff(int percent) {
        this.buff += percent;
    }
}
