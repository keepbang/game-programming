package common.exception;

public class CannotMountWeaponException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "해당 무기를 장착할 수 없습니다.";

    public CannotMountWeaponException() {
        super(EXCEPTION_MESSAGE);
    }
}
