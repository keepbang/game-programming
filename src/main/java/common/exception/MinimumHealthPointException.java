package common.exception;

public class MinimumHealthPointException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "HP값이 잘못 입려되었습니다.";

    public MinimumHealthPointException() {
        super(EXCEPTION_MESSAGE);
    }
}
