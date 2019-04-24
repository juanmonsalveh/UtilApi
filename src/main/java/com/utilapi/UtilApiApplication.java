package com.utilapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtilApiApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilApiApplication.class);

	public static void main(String[] args) {

        SpringApplication.run(UtilApiApplication.class, args);

        LOGGER.trace("TRACE log for test");
        LOGGER.debug("DEBUG log for test");
        LOGGER.info("INFO log for test");
        LOGGER.warn("WARN log for test");
        LOGGER.error("ERROR log for test");


    }

}
