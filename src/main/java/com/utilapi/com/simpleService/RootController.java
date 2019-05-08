package com.utilapi.com.simpleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

//    @ApiOperation(value = "Returns a simple message to test the controller´s availability")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Ok", response = String.class),
//            @ApiResponse(code = 500, message = "Service Error")
//    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootMethod () {
        LOGGER.debug("Start rootMethod");
        LOGGER.debug("End rootMethod");
        return RootService.rootService();
    }
}
