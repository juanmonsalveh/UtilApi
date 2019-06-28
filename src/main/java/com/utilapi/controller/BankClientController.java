package com.utilapi.controller;

import com.utilapi.core.dto.TransactionDTO;
import com.utilapi.core.facade.ICoreBank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bank-client")
public class BankClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankClientController.class);

    private final ICoreBank iCoreBank;

    @Autowired
    public BankClientController(ICoreBank iCoreBank) {
        this.iCoreBank = iCoreBank;
    }

    @GetMapping(value="/transaction", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getAllUserTransactions(@RequestParam Optional<String> username) {

        return username
                .map(s -> ResponseEntity.ok(iCoreBank.retrieveTransactions(s)))
                .orElseGet(() -> ResponseEntity.ok(iCoreBank.retrieveTransactions()));
    }

    @PostMapping(value="/transaction", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity createTransaction(@RequestBody TransactionDTO bankUser) {

        return ResponseEntity.ok(iCoreBank.createTransactionDto(bankUser));
    }

    @GetMapping(value="/transaction/otp/", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity validateTransactionOtp(@RequestParam String sharedkey,
                                         @RequestParam String otp) {

        ResponseEntity responseEntity;
        if (iCoreBank.validateTransactionOtp(sharedkey, otp)) {
            responseEntity = ResponseEntity.ok(true );
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(false);
        }
        return responseEntity;
    }
}
