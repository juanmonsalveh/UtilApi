package com.utilapi.utilapi;


import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtilapiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilapiApplication.class);

	public static void main(String[] args) {
        BasicConfigurator.configure();

        SpringApplication.run(UtilapiApplication.class, args);

        LOGGER.trace("TRACE log for test");
        LOGGER.debug("DEBUG log for test");
        LOGGER.info("INFO log for test");
        LOGGER.warn("WARN log for test");
        LOGGER.error("ERROR log for test");


    }

}
