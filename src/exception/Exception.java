package exception;

import common.ErrorCode;

public class Exception extends RuntimeException {
    private final ErrorCode errorCode;

    public Exception(ErrorCode errorCode) {
        super(errorCode.getError());
        this.errorCode = errorCode;
    }

}

