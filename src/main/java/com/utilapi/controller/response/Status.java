package com.utilapi.controller.response;

/**
 * Created by dagomanzano on 12/01/18.
 */
public enum Status {
    SUCCESS("1", Constant.success),
    FAIL("2",Constant.fail),
    ERROR("3", Constant.error),
    SUCCESSFUL("4", Constant.successfulCreation);

    private String code;
    private String message;

    Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
