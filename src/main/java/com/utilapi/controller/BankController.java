package com.utilapi.controller;

import com.utilapi.controller.exception.ApiException;
import com.utilapi.core.dto.UserDTO;
import com.utilapi.core.facade.ICoreUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController extends GeneralController {

    private final ICoreUser iCoreUser;

    private static final Logger LOGGER = LoggerFactory.getLogger(BankController.class);

    @Autowired
    public BankController(ICoreUser iCoreUser) {
        this.iCoreUser = iCoreUser;
    }

    @PostMapping(value="/user/register", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity registerUser(@RequestBody UserDTO bankUser) {
        try {
            boolean registeredUser = iCoreUser.registerUser(bankUser);
            return ResponseEntity.ok(buildJsonResponse(registeredUser));
        } catch (ApiException e) {
            return ResponseEntity.badRequest().body(errorThrow.handleError(e));
        }
    }

    @GetMapping(value="/user/login", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity loginUser(@RequestParam String username,
                            @RequestParam String password) {

        return ResponseEntity.ok().build();
    }
}
