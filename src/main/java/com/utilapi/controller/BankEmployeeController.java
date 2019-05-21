package com.utilapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bankemployee/")
public class BankEmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankEmployeeController.class);

    @GetMapping(value="/transaction/pending", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllPendingTransactions() {

        return "";
    }

    @GetMapping(value="/transaction/approve", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String approveTransaction(@RequestParam String transactionID) {

        return "";
    }
}
