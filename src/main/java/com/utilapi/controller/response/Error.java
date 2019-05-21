package com.utilapi.controller.response;

/**
 * Created by dagomanzano on 12/01/18.
 */

public class Error{
    private String code;
    private String message;

    public Error() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getMessage();
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

    public void setMessage(String status) {
        this.message= status;
    }


}
