package ability.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Status {
    private StatusType type;
    private LocalDateTime unlockStatusTime;

    public Status(StatusType type) {
        this.type = type;
        this.unlockStatusTime = LocalDateTime.MAX;
    }

    public void change(StatusType type, LocalDateTime unlockStatusTime) {
        this.type = type;
        this.unlockStatusTime = unlockStatusTime;
    }

    public StatusType currentStatus() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return type == status.type
                && Objects.equals(unlockStatusTime, status.unlockStatusTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, unlockStatusTime);
    }
}
