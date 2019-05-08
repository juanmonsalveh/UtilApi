package com.utilapi.com.simpleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootMethod () {
        LOGGER.debug("Start rootMethod");
        LOGGER.debug("End rootMethod");
        return RootService.rootService();
    }
}
