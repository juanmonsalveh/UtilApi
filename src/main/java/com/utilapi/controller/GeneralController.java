package com.utilapi.controller;

import com.google.gson.Gson;
import com.utilapi.controller.exception.ApiException;
import com.utilapi.controller.exception.ErrorThrow;
import com.utilapi.controller.response.ResponseObject;
import com.utilapi.controller.response.Status;
import okhttp3.internal.http2.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

/**
 * Created by dmanzano on 7/03/18.
 */
public class GeneralController {
    @Autowired
    protected ResponseObject responseObject;
    @Autowired
    protected Gson gson;
    @Autowired
    protected ErrorThrow errorThrow;


    protected String buildJsonResponse(Object any) throws ApiException {
        try {
            return new ResponseObject.Builder(any).build().toJson();
        }catch (Exception ex){
            throw new ApiException(ex.getMessage(), ErrorCode.INTERNAL_ERROR);
        }
    }

    protected String buildRegisterResponse ( boolean successfulRegistered) {
        String response = null;
        try {
            responseObject.setSelf(successfulRegistered);
            responseObject.setStatus(Status.SUCCESS);
            responseObject.setResponseCode("200");
            responseObject.setTimeString(Calendar.getInstance().getTime().toString());
            responseObject.setError(null);
            response = gson.toJson(responseObject);
        }catch(Exception ex){
            response = errorThrow.handleError(ex);
        }
        return response;
    }
}
