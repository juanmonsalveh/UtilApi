package com.utilapi.controller.exception;

import com.google.gson.Gson;
import com.utilapi.controller.response.PrintWriteResponse;
import com.utilapi.controller.response.ResponseObject;
import com.utilapi.controller.response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dmanzano on 12/07/18.
 */
@Service
public class ErrorThrow {

    protected ResponseObject responseObject;
    protected Gson gson;
    private PrintWriteResponse printStackTrace;
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorThrow.class);
    private Boolean errorShowProd;

    public ErrorThrow() {
        this.errorShowProd = true;
        gson = new Gson();
    }


    public  String handleError(Exception e){
        String errorMessage;

        if (errorShowProd) {
            e.printStackTrace(printStackTrace);
            errorMessage = e.toString() + " " + e.getCause() + "|" + printStackTrace.getStringWriter().toString();
        } else{
            errorMessage = e.toString();
        }

        responseObject = new ResponseObject.Builder(errorMessage)
                .setStatus(Status.ERROR)
                .build();

        String json = gson.toJson(responseObject);
        LOGGER.error(json);

        return json;
    }
}
