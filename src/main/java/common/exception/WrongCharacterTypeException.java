package common.exception;

public class WrongCharacterTypeException extends IllegalArgumentException{
    private static final String EXCEPTION_MESSAGE = "잘못된 종족을 입력하였습니다.";

    public WrongCharacterTypeException() {
        super(EXCEPTION_MESSAGE);
    }
}
