package com.utilapi.controller.response;


import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by dagomanzano on 11/01/18.
 */
public class ResponseObject {

    private Error error;
    private String responseCode;
    private String timeString;
    private Object self;
    private Status status;

    public ResponseObject(Builder builder) {
        this.error = builder.error;
        this.responseCode = builder.responseCode;
        this.timeString = builder.timeString;
        this.self = builder.self;
        this.status = builder.status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Object getSelf() {
        return self;
    }

    public ResponseObject setSelf(Object self) {
        this.self = self;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        if (null == error){
            error = new Error();
        }
        error.setCode(status.getCode());
        error.setMessage(status.getMessage());
    }

    public String toJson(){
        return new Gson().toJson(this);
    }

    public static class Builder {
        private Error error;
        private String responseCode;
        private String timeString;
        private Object self;
        private Status status;

        public Builder(Object self) {
            this.self = self;
            this.status = Status.SUCCESS;
            this.responseCode = "200";
            this.timeString = Calendar.getInstance().getTime().toString();
            this.error = new Error();
        }

        public Builder setError(Error error) {
            this.error = error;
            return this;
        }

        public Builder setResponseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder setTimeString(String timeString) {
            this.timeString = timeString;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            if (null == error){
                error = new Error();
            }
            error.setCode(status.getCode());
            error.setMessage(status.getMessage());
            return this;
        }

        public ResponseObject build(){
            return new ResponseObject(this);
        }
    }


}
