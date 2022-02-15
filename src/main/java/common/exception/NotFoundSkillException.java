package common.exception;

public class NotFoundSkillException extends IllegalArgumentException{
    private static final String EXCEPTION_MESSAGE = "스킬을 찾을 수 없습니다.";

    public NotFoundSkillException() {
        super(EXCEPTION_MESSAGE);
    }
}
