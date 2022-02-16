package ability.domain;

import java.time.LocalDateTime;

public class Status {
    private StatusType type;
    private LocalDateTime unlockStatusTime;

    public Status(StatusType type, LocalDateTime unlockStatusTime) {
        this.type = type;
        this.unlockStatusTime = unlockStatusTime;
    }

    public void change(StatusType type, LocalDateTime unlockStatusTime) {
        this.type = type;
        this.unlockStatusTime = unlockStatusTime;
    }

    public StatusType currentStatus() {
        return type;
    }
}
