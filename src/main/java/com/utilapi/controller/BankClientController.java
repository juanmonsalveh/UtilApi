package com.utilapi.controller;

import com.utilapi.core.dto.TransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankclient")
public class BankClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankClientController.class);

    @GetMapping(value="/transaction", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllUserTransactions(@RequestParam String sharedkey) {

        return "";
    }

    @PostMapping(value="/transaction", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerUser(@RequestBody TransactionDTO bankUser) {

        return "";
    }

    @GetMapping(value="/transaction/otp/validate", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllUserTransactions(@RequestParam String sharedkey,
                                         @RequestParam String otp) {

        return "";
    }
}
