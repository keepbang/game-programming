package ability.domain;

import java.util.Objects;

public class Level {
    private static final int ULTIMATE_LEVEL = 99;

    private int level;

    public Level(int level) {
        this.level = level;
    }

    public void levelUp() {
        this.level++;
    }

    public boolean isUltimate() {
        return level >= ULTIMATE_LEVEL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level1 = (Level) o;
        return level == level1.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}
