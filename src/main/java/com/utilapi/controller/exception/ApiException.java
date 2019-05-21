package com.utilapi.controller.exception;

import okhttp3.internal.http2.ErrorCode;

public class ApiException extends Exception {

    private static final long serialVersionUID = 7718828512143293558L;
    private final ErrorCode code;
    private String errorMessage;

    /**
     *
     * @param code
     */
    public ApiException(ErrorCode code) {
        super();
        this.code = code;
    }
    /**
     *
     * @param message
     * @param cause
     * @param code
     */
    public ApiException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.errorMessage = message;
        this.code = code;
    }

    /**
     *
     * @param message
     * @param code
     */
    public ApiException(String message, ErrorCode code) {
        super(message);
        this.errorMessage = message;
        this.code = code;
    }

    /**
     *
     * @param cause
     * @param code
     */
    public ApiException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    /**
     *
     * @return
     */
    public ErrorCode getCode() {
        return this.code;
    }

    /**
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
