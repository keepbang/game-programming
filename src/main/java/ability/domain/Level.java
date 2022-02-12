package ability.domain;

import java.util.Objects;

public class Level {
    private int level;

    public Level() {
        this.level = 1;
    }

    public Level(int level) {
        this.level = level;
    }

    public void levelUp() {
        this.level++;
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
