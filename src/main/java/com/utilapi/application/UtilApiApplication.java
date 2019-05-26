package com.utilapi.application;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.utilapi")
@EnableJpaRepositories(basePackages = {"com.utilapi.persistence"})
@EntityScan(basePackages = {"com.utilapi.persistence.*"})
@EnableTransactionManagement
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

